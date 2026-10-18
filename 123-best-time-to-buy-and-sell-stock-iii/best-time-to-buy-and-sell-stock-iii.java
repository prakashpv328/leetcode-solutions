class Solution {
    int dp[][][];
    public int maxProfit(int[] prices) {
        int l=prices.length;

        dp=new int[l+1][2][3];
        int profit=0;

        for(int i=l-1;i>=0;i--){
            for(int j=0;j<2;j++){
                for(int k=1;k<=2;k++){
                    if(j==1){
                        dp[i][j][k]=Math.max( -prices[i]+dp[i+1][0][k] , dp[i+1][1][k]);
                    }
                    else{
                        dp[i][j][k]=Math.max( prices[i]+dp[i+1][1][k-1] , dp[i+1][0][k]);
                    }
                }
            }
        }

        return dp[0][1][2];
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