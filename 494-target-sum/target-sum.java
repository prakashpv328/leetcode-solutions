class Solution {
    int dp[][];
    public int findTargetSumWays(int[] nums, int target) {
        int n=nums.length;
        dp=new int[n][2001];

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        return  funct(nums,target,n-1,0);
    }

    private int funct(int[] nums,int target,int idx,int sum){
        if(idx<0){
            return sum==target?1:0;
        }

        int dpsum=sum+1000;
        if(dp[idx][dpsum]!=-1){
            return dp[idx][dpsum];
        }

        int gain=0,loss=0;

        gain=funct(nums,target,idx-1,sum+nums[idx]);

        loss=funct(nums,target,idx-1,sum-nums[idx]);

        return dp[idx][dpsum]=gain+loss;
    }
}