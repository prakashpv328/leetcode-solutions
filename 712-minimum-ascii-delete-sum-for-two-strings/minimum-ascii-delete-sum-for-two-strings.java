class Solution {
    int dp[][];
    int m,n;
    public int minimumDeleteSum(String s1, String s2) {
        this.m=s1.length();
        this.n=s2.length();
        dp=new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            dp[i][0]=dp[i-1][0]+s1.charAt(i-1);
        }
        for(int j=1;j<=n;j++){
            dp[0][j]=dp[0][j-1]+s2.charAt(j-1);
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.min(s1.charAt(i-1)+dp[i-1][j],s2.charAt(j-1)+dp[i][j-1]);
                }
            }
        }

        return dp[m][n];
    }

    private int solve(int i,int j,String s1,String s2){
        if(i==0 && j==0) return 0;
        if(i==0){
            int sum=0;
            for(int k=j;k>0;k--){
                sum+=s2.charAt(k-1);
            }
            return sum;
        }
        if(j==0){
            int sum=0;
            for(int k=i;k>0;k--){
                sum+=s1.charAt(k-1);
            }
            return sum;
        }

        if(dp[i][j]!=-1) return dp[i][j];

        int ans=Integer.MAX_VALUE;

        if(s1.charAt(i-1)==s2.charAt(j-1)){
            ans=solve(i-1,j-1,s1,s2);
        }
        else{
            ans=Math.min(ans,Math.min(s1.charAt(i-1)+solve(i-1,j,s1,s2),
                                        s2.charAt(j-1)+solve(i,j-1,s1,s2)));
        }

        return dp[i][j]=ans;
    }
}