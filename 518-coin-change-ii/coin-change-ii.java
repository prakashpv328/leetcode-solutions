class Solution {
    int[][] dp;

    public int change(int amount, int[] coins) {

        int n = coins.length;

        dp = new int[amount + 1][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return solve(amount, coins, 0, 0);
    }

    private int solve(int amount, int[] coins, int i, int sum) {

        if (sum == amount) {
            return 1;
        }

        if (sum > amount || i == coins.length) {
            return 0;
        }

        if (dp[sum][i] != -1) {
            return dp[sum][i];
        }

        // Take current coin
        int take = solve(
            amount,
            coins,
            i,
            sum + coins[i]
        );

        // Skip current coin
        int skip = solve(
            amount,
            coins,
            i + 1,
            sum
        );

        return dp[sum][i] = take + skip;
    }
}