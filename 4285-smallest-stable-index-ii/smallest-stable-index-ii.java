class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int l=nums.length;
        int []suf=new int[l];
        
        suf[l-1]=nums[l-1];
        for(int i=l-2;i>=0;i--){
            suf[i]=Math.min(nums[i],suf[i+1]);
        }

        int max=nums[0];
        for(int i=0;i<l;i++){
            max=Math.max(max,nums[i]);
            if(max-suf[i]<=k){
                return i;
            }
        }
        return -1;
        
    }
}