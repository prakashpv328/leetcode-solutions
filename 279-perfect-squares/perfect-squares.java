class Solution {
    int []dp;
    public int numSquares(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return funct(n);
    }

    private int funct(int n){
        if(n==0) return 0;
        if(dp[n]!=-1) return dp[n];
        int ans=Integer.MAX_VALUE;
        for(int i=1;i*i<=n;i++){
            int s=i*i;
            ans=Math.min(ans,1+funct(n-s));
        }
        return dp[n]=ans;
    }
}