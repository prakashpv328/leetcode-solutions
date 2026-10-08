class Solution {
    int dp[][];
    public int minSteps(int n) {
        if(n==1) return 0;

        dp=new int[n+1][n+1];

        for(int i=0;i<n+1;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(1,0,n);
    }

    private int solve(int curr,int clip,int n){
        if(curr==n){
            return 0;
        }

        if(curr>n) return 1000000;

        if(dp[curr][clip]!=-1) return dp[curr][clip];

        int copy=1000000;

        if(curr!=clip){
            copy = 1+solve(curr,curr,n);
        }

        int paste=1000000;

        if(clip>0){
            paste=1+solve(curr+clip,clip,n);
        }

        return dp[curr][clip]=Math.min(copy,paste);
    }
}