class Solution {
    int n;
    int dp[];
    public int minimumCoins(int[] prices) {
        this.n=prices.length;
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(prices,0);
    }

    int solve(int[] prices,int idx){
        if(idx>=n){
            return 0;
        }

        if(dp[idx]!=-1) return dp[idx];
        int ans=1000000;
        for(int i=idx+1;i<=idx+idx+2;i++){
            ans=Math.min(solve(prices,i),ans);
        }

        return dp[idx]=ans+prices[idx];
    }

}