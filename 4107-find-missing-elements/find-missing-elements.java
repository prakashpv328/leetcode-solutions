class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int l= nums.length;
        Arrays.sort(nums);
        int a=nums[0];
        List<Integer> ans=new ArrayList<>();

        for(int i=0;i<l;i++){
            for(int j=a+1;j<nums[i];j++){
                ans.add(j);
            }
            a=nums[i];
        }
        return ans;
    }
}