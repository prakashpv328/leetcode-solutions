class Solution {
    int dp[][];
    public boolean canPartition(int[] nums) {
        int l=nums.length;
        int sum=0;
        for(int i=0;i<l;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        dp=new int[l][sum/2+1];

        for(int i=0;i<l;i++)
        Arrays.fill(dp[i],-1);

        return solve(nums,0,sum/2)==1;
    }

    private int solve(int []nums,int idx,int target){
        if(target<0|| idx==nums.length) {
            return 0;
        }
        if(target==0) return 1;

        if(dp[idx][target]!=-1) return dp[idx][target];

        int take=solve(nums,idx+1,target-nums[idx]);
        int skip=solve(nums,idx+1,target);

        if(take==1 || skip==1) dp[idx][target]=1;
        else dp[idx][target]=0;

        return dp[idx][target];
    }
}