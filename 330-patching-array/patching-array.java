class Solution {
    public int minPatches(int[] nums, int n) {
        int l=nums.length;
        int ans=0;
        long reach=0;
        int i=0;
        while(reach<n){
            if(i<l && nums[i]<=reach+1){
                reach+=nums[i];
                i++;
            }
            else{
                reach=reach+reach+1;
                ans++;
            }
        }
        return ans;
    }
}