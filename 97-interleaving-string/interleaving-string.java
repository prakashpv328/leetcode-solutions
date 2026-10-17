class Solution {
    int dp[][];
    int m,n,l;
    public boolean isInterleave(String s1, String s2, String s3) {
        this.m=s1.length();
        this.n=s2.length();
        this.l=s3.length();
        if(m+n!=l) return false;

        dp=new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(m,n,s1,s2,s3)==1;
    }

    private int solve(int i,int j,String s1,String s2,String s3){
        if(i==0 && j==0) return dp[i][j]=1;

        if(dp[i][j]!=-1) return dp[i][j];

        int k=i+j;

        if(i>0 && s1.charAt(i-1)==s3.charAt(k-1)){
            if(solve(i-1,j,s1,s2,s3)==1){
                return dp[i][j]=1;
            }
        }

        if(j>0 && s2.charAt(j-1)==s3.charAt(k-1)){
            if(solve(i,j-1,s1,s2,s3)==1){
                return dp[i][j]=1;
            }
        }

        return dp[i][j]=0;
    }
}