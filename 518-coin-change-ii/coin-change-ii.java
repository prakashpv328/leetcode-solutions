class Solution {
    int [][]dp;
    int l;
    public int change(int amount, int[] coins) {
        l=coins.length;
        dp=new int[amount+1][l];
        for(int []row:dp)
        Arrays.fill(row,-1);

        return solve(amount,coins,0,0);
    }
    private int solve(int amount,int[] coins,int i,int sum){
        if(sum>=amount || i==l){
            if(sum==amount){
                return 1;
            }
            return 0;
        }
        if(dp[sum][i]!=-1) return dp[sum][i];
        int take=solve(amount,coins,i,sum+coins[i]);
        int skip=solve(amount,coins,i+1,sum);
        return dp[sum][i]=take+skip;
    }
}