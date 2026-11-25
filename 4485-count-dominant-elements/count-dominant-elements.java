class Solution {
    public int countDominantElements(int[] nums) {
        int res=0;
        int l=nums.length;
        for(int i=0;i<l;i++){
            if(nums[i]*2>=nums[Math.max(0,i-1)]+nums[Math.min(l-1,i+1)])
                res++;
        }
        return res;
    }
}