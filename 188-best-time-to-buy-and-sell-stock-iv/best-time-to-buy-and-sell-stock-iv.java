class Solution {
    public int maxProfit(int rem, int[] prices) {
        int l=prices.length;

        // dp=new int[l+1][2][3];
        
        int [][]front=new int[2][rem+1];
        int [][]curr=new int[2][rem+1];
        int profit=0;

        for(int i=l-1;i>=0;i--){
            for(int j=0;j<2;j++){
                for(int k=1;k<=rem;k++){
                    if(j==1){
                        curr[j][k]=Math.max( -prices[i]+front[0][k] , front[1][k]);
                    }
                    else{
                        curr[j][k]=Math.max( prices[i]+front[1][k-1] , front[0][k]);
                    }
                }
            }
            front=curr;
        }

        return front[1][rem];
    }
}