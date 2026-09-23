class Solution {
    int ans=0;
    int[] dp;
    public int combinationSum4(int[] nums, int target) {
        int count=0;
        int sum=0;
        int tot=0;
        dp=new int[target+1];
        Arrays.fill(dp,-1);
        return funct(0,target,nums);
    }

    public int funct(int sum,int target,int[] nums){
        if(sum==target){
            return 1;
        }
        if(sum>target){
            return 0;
        }
        if(dp[sum]!=-1) return dp[sum];
        int count=0;
        for(int i=0;i<nums.length;i++){
            count+=funct(sum+nums[i],target,nums);
        }
        return dp[sum]=count;
    }
}