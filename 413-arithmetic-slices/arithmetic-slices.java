class Solution {

    public int numberOfArithmeticSlices(int[] nums) {
        int ans=0;
        int l=nums.length;
        int dp[]=new int[l+1];
        Arrays.fill(dp,-1);
        for(int i=0;i<l;i++){
            ans+=solve(i,nums,dp);
        }
        return ans;
    }
    private int solve(int i,int []nums,int[] dp){
        if(i<2) return 0;
        if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
            if(dp[i-1]!=-1) return dp[i-1];
            return dp[i-1]=solve(i-1,nums,dp)+1;
        }
        return 0;
    }
}