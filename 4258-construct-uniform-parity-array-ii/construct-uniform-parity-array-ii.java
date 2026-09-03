class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=Integer.MAX_VALUE;
        int even=1;
        int l=nums1.length;
        int o=0,e=0;
        for(int i=0;i<l;i++){
            if(nums1[i]%2==0){
                e++;
            }
            else{
                even=0;
                o++;
            }
            min=Math.min(min,nums1[i]);
        }
        if(even==1) return true;
        if(min%2!=0) return true;

        return false;
    }
}