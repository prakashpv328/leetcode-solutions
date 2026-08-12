class Solution {
    public int wiggleMaxLength(int[] nums) {
        int l=nums.length;
        if(l<2) return l;
        int ans=1;
        int prev=0;
        for(int i=1;i<l;i++){
            int diff=nums[i]-nums[i-1];
            if((diff>0 && prev<=0) || (diff<0 && prev>=0)){
                ans++;
                prev=diff;
            }
        }
        return ans;
    }
}