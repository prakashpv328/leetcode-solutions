class Solution {
    int dp[][];
    int n;
    public int minDifficulty(int[] jobDifficulty, int d) {
        this.n=jobDifficulty.length;
        if(d>n) return -1;
        dp=new int[n+1][d+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(0,d,jobDifficulty);
    }

    private int solve(int idx,int d,int []nums){
        if(idx==n){
            return d==0?0:Integer.MAX_VALUE;
        }
        if(d==0) return Integer.MAX_VALUE;

        if(dp[idx][d]!=-1) return dp[idx][d];

        long max=Integer.MIN_VALUE;
        long ans=Integer.MAX_VALUE;
        for(int i=idx;i<n;i++){
            max=Math.max(max,nums[i]);
            ans=Math.min(ans,max+(long)solve(i+1,d-1,nums));
        }

        return dp[idx][d]=(int)ans;
    }
}