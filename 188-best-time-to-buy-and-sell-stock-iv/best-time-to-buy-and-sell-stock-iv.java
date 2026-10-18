class Solution {
    public int maxProfit(int rem, int[] prices) {
        int l=prices.length;

        // dp=new int[l+1][2][3];

        int []front=new int[rem*2+1];
        int []curr=new int[rem*2+1];

        for(int i=l-1;i>=0;i--){
            for(int j=0;j<rem*2;j++){
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
}