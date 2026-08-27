class Solution {
    public int rob(int[] nums) {
        int l=nums.length;
        if(l==1) return nums[0];
        int prev2=nums[0];
        int prev1=Math.max(prev2,nums[1]);
        int curr=prev1;

        for(int i=2;i<l;i++){
            curr=Math.max(nums[i]+prev2,prev1);
            prev2=prev1;
            prev1=curr;
        }
        return curr;
    }
}