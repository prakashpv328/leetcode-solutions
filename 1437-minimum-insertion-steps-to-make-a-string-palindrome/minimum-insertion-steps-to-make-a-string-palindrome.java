class Solution {
    int dp[][];
    int n;
    public int minInsertions(String str1) {
        this.n=str1.length();
        String str2=new String(new StringBuilder(str1).reverse().toString());
        dp=new int[n+1][n+1];

        // for(int i=0;i<=n;i++){
        //     Arrays.fill(dp[i],-1);
        // }

        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int j=0;j<=n;j++) dp[0][j]=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return n-dp[n][n];
    }

    private int solve(int i,int j,String str1,String str2){
        if(i==0 || j==0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(str1.charAt(i-1)==str2.charAt(j-1)){
            return dp[i][j]=1+solve(i-1,j-1,str1,str2);
        }
        return dp[i][j]=Math.max(solve(i,j-1,str1,str2),solve(i-1,j,str1,str2));
    }
}