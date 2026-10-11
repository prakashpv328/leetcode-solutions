class Solution {
    int dp[][];
    int n,m;
    public int minDistance(String word1, String word2) {
        this.n=word1.length();
        this.m=word2.length();
        dp=new int[n+1][m+1];

        // for(int i=0;i<=n;i++){
        //     Arrays.fill(dp[i],-1);
        // }

        for(int i=0;i<=n;i++) dp[i][0]=0;
        for(int j=0;j<=m;j++) dp[0][j]=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        return n+m-dp[n][m]*2;
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