class Solution {
    int dp[][];
    int m,n;
    public int minDistance(String word1, String word2) {
        this.m=word1.length();
        this.n=word2.length();

        dp=new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }

        // for(int i=0;i<=m;i++) dp[i][0]=0;
        // for(int i=0;i<=n;i++) dp[0][i]=0;

        // for(int i=1;i<=m;i++){
        //     for(int j=1;j<=n;j++){
        //         if(word1.charAt(i-1)==word2.charAt(j-1))
        //             dp[i][j]=1+dp[i-1][j-1];
        //         else
        //             dp[i][j]=0;

        //     }
        // }

        return solve(m,n,word1,word2);
    }


    private int solve(int i,int j,String str1,String str2){
        if(i==0) return j;
        if(j==0) return i;

        if(dp[i][j]!=-1) return dp[i][j];

        if(str1.charAt(i-1)==str2.charAt(j-1)){
            return dp[i][j]=solve(i-1,j-1,str1,str2);
        }
         
        int ins=solve(i,j-1,str1,str2);
        int del=solve(i-1,j,str1,str2);
        int rep=solve(i-1,j-1,str1,str2);

        return dp[i][j]=1+Math.min(ins,Math.min(del,rep));
    }
}