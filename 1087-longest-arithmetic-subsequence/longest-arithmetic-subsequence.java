class Solution {
    int [][]dp;
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        int ans=0;
        dp=new int[n][1001];
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int diff=nums[j]-nums[i];
                int d=500+diff;

                if(dp[j][d]==0){
                    dp[i][d]=Math.max(dp[i][d],2);
                }
                else {
                    dp[i][d]=Math.max(dp[i][d],dp[j][d]+1);
                }
                ans=Math.max(ans,dp[i][d]);
            }
        }
        return ans;
    }
}