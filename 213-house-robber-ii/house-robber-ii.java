class Solution {
    public int rob(int[] nums) {
        int l=nums.length;
        if(l==1) return nums[0];
        int []nums1=new int[l-1];
        int []nums2=new int[l-1];
        for(int i=0;i<l;i++){
            if(i!=0){
                nums1[i-1]=nums[i];
            }
            if(i!=l-1){
                nums2[i]=nums[i];
            }
        }
        return Math.max(getMax(nums1),getMax(nums2));
    }

    int getMax(int[] nums){
        int l=nums.length;
        if(l==1) return nums[0];
        int prev2=nums[0];
        int prev1=Math.max(prev2,nums[1]);
        int curr=prev1;
        for(int i=2;i<l;i++){
            curr=Math.max(prev2+nums[i],prev1);
            prev2=prev1;
            prev1=curr;
        }
        return curr;
    }
}