class Solution {
    int dp[][];
    int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        dp=new int[n+1][target+1];
        for(int i=0;i<n+1;i++) Arrays.fill(dp[i],-1);
        return solve(n,k,target);
    }

    private int solve(int n,int k,int target){
        if(n==0){
            if(target==0){
                return 1;
            }
            return 0;
        }
        if(target<0) return 0;
        if(dp[n][target]!=-1) return dp[n][target];
        long ans=0;
        for(int i=1;i<=k;i++){
            ans+=solve(n-1,k,target-i);
            ans=ans%MOD;
        }
        return dp[n][target]=(int)ans;

    }
}