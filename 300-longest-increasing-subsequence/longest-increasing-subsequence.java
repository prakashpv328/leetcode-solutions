class Solution {
    int l;
    int dp[][];
    public int lengthOfLIS(int[] nums) {
        this.l=nums.length;
        // dp=new int[l+1][l+1];

        int []prev=new int[l+1];
        int []curr=new int[l+1];

        // for(int i=l-1;i>=0;i--){
        //     for(int j=i-1;j>=-1;j--){
        //         int len=prev[j+1];

        //         if(j==-1 || nums[i]>nums[j]){
        //             len=Math.max(len,1+prev[i+1]);
        //         }
        //         curr[j+1]=len;
        //     }
        //     prev=curr;
        // }

        int dp[]=new int[l];
        Arrays.fill(dp,1);
        int ans=0;
        for(int i=0;i<l;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j])
                dp[i]=Math.max(dp[i],dp[j]+1);
            }
            ans=Math.max(ans,dp[i]);
        }

        return ans;
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