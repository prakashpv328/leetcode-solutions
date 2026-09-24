class Solution {
    int dp[][];
    public boolean canPartition(int[] nums) {
        int l=nums.length;
        int sum=0;
        for(int i=0;i<l;i++){
            sum+=nums[i];
        }
        if(sum%2!=0) return false;
        dp=new int[l][sum/2];

        for(int i=0;i<l;i++)
        Arrays.fill(dp[i],-1);

        return solve(nums,0,0,sum/2)==1;
    }

    private int solve(int []nums,int sum,int idx,int target){
        if(sum>target || idx==nums.length) {
            return 0;
        }
        if(sum==target) return 1;

        if(dp[idx][sum]!=-1) return dp[idx][sum];

        int take=solve(nums,sum+nums[idx],idx+1,target);
        int skip=solve(nums,sum,idx+1,target);

        if(take==1 || skip==1) dp[idx][sum]=1;
        else dp[idx][sum]=0;

        return dp[idx][sum];
    }
}