class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map= new HashMap<>();
        int l=0,ans=0;
        for(int r=0;r<n;r++){
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(map.get(nums[r])>k){
                map.put(nums[l],map.getOrDefault(nums[l++],0)-1);
            }
            ans=Math.max(ans,r-l+1);
        }
        return ans;
    }
}