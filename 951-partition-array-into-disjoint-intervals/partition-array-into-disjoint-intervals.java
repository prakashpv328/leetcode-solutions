class Solution {
    public int partitionDisjoint(int[] nums) {
        int l=nums.length;
        int []pmax=new int[l];
        int []smax=new int[l];
        smax[l-1]=nums[l-1];
        pmax[0]=nums[0];
        for(int i=1;i<l;i++){
            pmax[i]=Math.max(nums[i],pmax[i-1]);
        }

        for(int i=l-2;i>=0;i--){
            smax[i]=Math.min(nums[i],smax[i+1]);
        }

        for(int i=0;i<l-1;i++){
            if(pmax[i]<=smax[i+1]){
                return i+1;
            }
        }
        return -1;
    }
}