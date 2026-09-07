class Solution {
    int []dp;
    public int numTrees(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n);
    }

    private int solve(int n){
        if(n<=1) return 1;
        if(dp[n]!=-1) return dp[n];
        int ans=0;
        for(int i=1;i<=n;i++){
            int l=solve(i-1);
            int r=solve(n-i);
            ans+=l*r;
        }
        return dp[n]=ans;
    }

}