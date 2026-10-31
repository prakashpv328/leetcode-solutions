class Solution {
    int dp[][];
    int n;
    public int getLengthOfOptimalCompression(String s, int k) {
        this.n=s.length();
        dp=new int[n][k+1];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(0,k,s);
    }

    private int solve(int i,int k,String s){
        if(k>=n-i) return 0;

        if(dp[i][k]!=-1) return dp[i][k];

        int ans=Integer.MAX_VALUE;

        if(k>0){
            ans=solve(i+1,k-1,s);
        }

        int count =0;
        int del=0;

        for(int j=i;j<n;j++){
            if(s.charAt(i)==s.charAt(j)){
                count++;
            }
            else{
                del++;
            }

            if(del<=k){
                int tot=1;
                if(count==100) tot=4;
                else if(count>=10) tot=3;
                else if(count>=2) tot=2;

                ans=Math.min(ans,solve(j+1,k-del,s)+tot);
            }
        }
        return dp[i][k]=ans;
    }
}