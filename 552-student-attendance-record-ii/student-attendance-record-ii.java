class Solution {
    int [][][]dp;
    int MOD=1000000007;
    public int checkRecord(int n) {
        dp=new int[n+1][2][3];

        for(int i=0;i<=n;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }

        return solve(n,0,0);
    }

    private int solve(int n,int a,int l){
        if(n==0) return 1;

        if(dp[n][a][l]!=-1) return dp[n][a][l];

        long ans=solve(n-1,a,0);

        if(a<1){
            ans=(ans+solve(n-1,1,0))%MOD;
        }

        if(l<2){
            ans=(ans+solve(n-1,a,l+1))%MOD;
        }

        return dp[n][a][l]=(int)ans;
    }
}