class Solution {
    int dp[];
    int l;
    public int minCut(String s) {
        this.l=s.length();

        dp=new int[l+1];
        Arrays.fill(dp,-1);

        return solve(0,s)-1;
    }

    private int solve(int i,String s){
        if(i==l) return 0;

        if(dp[i]!=-1) return dp[i];

        int ans=Integer.MAX_VALUE;

        for(int j=i;j<l;j++){
            if(isPalindrome(i,j,s)){
                int cost=1+solve(j+1,s);
                ans=Math.min(ans,cost);
            }
        }

        return dp[i]=ans;
    }

    private boolean isPalindrome(int i,int j,String str){
        while(i<=j){
            if(str.charAt(i++)!=str.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}