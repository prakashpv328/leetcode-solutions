class Solution {
    int dp[][][];
    public int maxProfit(int[] prices) {
        int l=prices.length;

        // dp=new int[l+1][2][3];

        int []front=new int[5];
        int []curr=new int[5];

        for(int i=l-1;i>=0;i--){
            for(int j=0;j<4;j++){
                if(j%2==0){
                    curr[j]=Math.max( -prices[i]+front[j+1] , front[j]);
                }
                else{
                    curr[j]=Math.max( prices[i]+front[j+1] , front[j]);
                }
            }
            front=curr;
        }

        return front[0];
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