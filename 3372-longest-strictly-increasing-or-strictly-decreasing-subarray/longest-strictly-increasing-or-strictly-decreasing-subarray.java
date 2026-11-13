class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxI=1,maxD=1;
        int l=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]) l++;
            else l=1;
            maxI=Math.max(maxI,l);
        }
        l=1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]>nums[i+1]) l++;
            else l=1;
            maxD=Math.max(maxD,l);
        }

        return Math.max(maxI,maxD);
    }
}