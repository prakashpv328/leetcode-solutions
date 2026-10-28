class Solution {
    int dp[][];
    int MOD=1000000007;
    public int kInversePairs(int n, int k) {
        dp=new int[n+1][k+1];
        dp[0][0]=1;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=k;j++){
                for(int x=0;x<=Math.min(j,i-1);x++){
                    if(j-x>=0){
                        dp[i][j]=(dp[i][j]+dp[i-1][j-x])%MOD;
                    }
                }
            }
        }

        return dp[n][k];
    }

    private int solve(int n,int k){
        if(k<0) return 0;

        if(n==0) return k==0?1:0;


        if(dp[n][k]!=-1) return dp[n][k];

        long ans=0;

        for(int i=0;i<=Math.min(k,n-1);i++){
            ans=(ans+solve(n-1,k-i))%MOD;
        }

        return dp[n][k]=(int)ans;
    }
}