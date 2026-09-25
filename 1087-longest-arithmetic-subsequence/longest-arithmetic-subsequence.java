class Solution {
    int [][]dp;
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        int ans=0;
        dp=new int[n][1001];
        
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int diff=nums[j]-nums[i];
                ans=Math.max(ans,solve(nums,i,diff));
            }
        }
        return ans;
    }

    private int solve(int[] nums,int cur,int diff) {
        int d=500+diff;
        if(dp[cur][d]!=0) return dp[cur][d];
        int ans=1;
        for(int i=0;i<cur;i++){
            if(nums[i]-nums[cur]==diff){
                ans=Math.max(ans,solve(nums,i,diff)+1);
            }
        }

        return dp[cur][d]=ans;
    }
}