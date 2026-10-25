class Solution {
    int MOD=1000000007;
    int dp[][];
    public int countVowelPermutation(int n) {
        long ans=0;
        dp=new int[n+1][5];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<5;i++){
            ans=(ans+solve(n,i))%MOD;
        }
        return (int)ans;
    }

    private long solve(int n,int v){
        if(n==1) return 1;

        if(dp[n][v]!=-1) return dp[n][v];

        long ans=0;

        if(v==0){
            ans=solve(n-1,1)+solve(n-1,2)+solve(n-1,4);
        }
        else if(v==1){
            ans=solve(n-1,0)+solve(n-1,2);
        }
        else if(v==2){
            ans=solve(n-1,1)+solve(n-1,3);
        }
        else if(v==3){
            ans=solve(n-1,2);
        }
        else{
            ans=solve(n-1,2)+solve(n-1,3);
        }

        return dp[n][v]=(int)(ans%MOD);
    }
}