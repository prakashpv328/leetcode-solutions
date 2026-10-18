class Solution {
    public int maxProfit(int[] prices, int fee) {
        int l=prices.length;
        int dp[][]=new int[l+2][2];

        int []after=new int[2];
        int []curr=new int[2];

        for(int i=l-1;i>=0;i--){
            curr[1]=Math.max( -prices[i]+after[0] , after[1]);
            curr[0]=Math.max( prices[i]+after[1]-fee , after[0]);
            after=curr;
        }
        return after[1];
    }
}