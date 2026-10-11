//here i use n+1,m+1 length to eleminate -index in tabulation in dp array

class Solution {
    int dp[][];
    int n,m;
    public int longestCommonSubsequence(String text1, String text2) {
        this.n=text1.length();
        this.m=text2.length();
        dp=new int[n+1][m+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(n,m,text1,text2);
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