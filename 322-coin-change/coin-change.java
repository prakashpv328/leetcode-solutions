class Solution {
    int dp[];
    public int coinChange(int[] coins, int amount) {
        int l=coins.length;
        dp=new int[amount+1];
        Arrays.fill(dp,-1);
        int ans=solve(coins,amount);
        return ans==Integer.MAX_VALUE?-1:ans;
    }

    private int solve(int []coins,int amount){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        if(dp[amount]!=-1) return dp[amount];
        int ans=Integer.MAX_VALUE;
       
        for(int coin:coins){
            int result=solve(coins,amount-coin);
            if(result!=Integer.MAX_VALUE){
                ans=Math.min(ans,result+1);
            }
        }
        return dp[amount]=ans;
    }
}