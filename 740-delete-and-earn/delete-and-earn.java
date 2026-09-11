class Solution {
    int []points;
    int []dp;
    public int deleteAndEarn(int[] nums) {
        int l=nums.length;
        int max=0;
        for(int x:nums){
            max=Math.max(max,x);
        }
        points=new int[max+1];
        dp=new int[max+1];
        Arrays.fill(dp,-1);
        for(int x:nums){
            points[x]+=x;
        }
        return solve(max);

    }
    private int solve(int num){
        if(num<=0) return 0;
        if(dp[num]!=-1) return dp[num];
        int take=points[num]+solve(num-2);
        int skip=solve(num-1);
        return dp[num]=Math.max(take,skip);
    }
}