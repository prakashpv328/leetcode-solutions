class Solution {
    int dp[][][];
    public int maxProfit(int[] prices) {
        int l=prices.length;

        dp=new int[l+1][2][3];
        for(int i=0;i<=l;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return solve(prices,0,true,2);
    }

    private int solve(int []prices,int idx,boolean buy,int rem){

        if(rem==0 || idx==prices.length) return 0;

        if(dp[idx][buy?1:0][rem]!=-1) return dp[idx][buy?1:0][rem];

        int profit=0;

        if(buy){
            profit=Math.max(-prices[idx]+solve(prices,idx+1,false,rem),
                                solve(prices,idx+1,true,rem));
        }
        else{
            profit=Math.max(prices[idx]+solve(prices,idx+1,true,rem-1),
                                solve(prices,idx+1,false,rem));
        }

        return dp[idx][buy?1:0][rem]=profit;
    }
}