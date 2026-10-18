class Solution {
    public int maxProfit(int[] prices) {
        int l=prices.length;
        int dp[][]=new int[l+2][2];

        for(int i=l-1;i>=0;i--){
            dp[i][1]=Math.max( -prices[i]+dp[i+1][0] , dp[i+1][1]);
            dp[i][0]=Math.max( prices[i]+dp[i+2][1] , dp[i+1][0]);
        }
        return dp[0][1];
    }
}