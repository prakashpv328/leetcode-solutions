class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = nums.length;
        for (int i = 0; i < l; i++) {
            int c = target - nums[i];
            if (map.containsKey(c) && map.get(c) != i) {
                return new int[] { i, map.get(c) };
            }
            map.put(nums[i], i);
        }
        return null;
    }
}