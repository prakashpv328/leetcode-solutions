class Solution {
    int l;
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        this.l=nums.length;
        dp=new int[l][l+1];

        for(int i=0;i<l;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(0,-1,nums);
    }

    private int solve(int idx,int prev,int []nums){
        if(idx==l) return 0;

        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];

        int len=solve(idx+1,prev,nums);

        if(prev==-1 || nums[idx]>nums[prev]){
            len=Math.max(len,1+solve(idx+1,idx,nums));
        }

        return dp[idx][prev+1]=len;
    }
}