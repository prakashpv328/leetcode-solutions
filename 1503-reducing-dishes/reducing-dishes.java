class Solution {
    int n;
    int dp[][];
    public int maxSatisfaction(int[] satisfaction) {
        n=satisfaction.length;
        Arrays.sort(satisfaction);
        dp=new int[n+1][n+1];

        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);

        return solve(0,1,satisfaction);
    }

    private int solve(int idx,int count,int []satisfaction){
        if(idx==n){
            return 0;
        }

        if(dp[idx][count]!=-1) return dp[idx][count];

        int take=count*satisfaction[idx]+solve(idx+1,count+1,satisfaction);
        int skip=solve(idx+1,count,satisfaction);

        return dp[idx][count]=Math.max(take,skip);
    }
}