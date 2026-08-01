class Solution {

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        return solve(nums, 0, n - 1) >= 0;
    }

    public int solve(int[] nums, int i, int j) {
        if (i == j) {
            return nums[i];
        }
        int l = nums[i] - solve(nums, i + 1, j);

        int r = nums[j] - solve(nums, i, j - 1);

        return Math.max(l, r);
    }
}