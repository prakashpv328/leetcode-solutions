class Solution {
    int dp[][];
    int m,n;
    public int maximalSquare(char[][] matrix) {
        this.m=matrix.length;
        this.n=matrix[0].length;

        dp=new int[m+1][n+1];

        int ans=0;
                
        for(int r=1;r<=m;r++){
            for(int c=1;c<=n;c++){
                if(matrix[r-1][c-1]=='1'){
                    int up=dp[r-1][c];
                    int left=dp[r][c-1];
                    int dig=dp[r-1][c-1];
                    dp[r][c]=1+Math.min(up,Math.min(left,dig));
                    ans=Math.max(ans,dp[r][c]);
                }
            }
        }
        return ans*ans;
    }

    private int solve(int i,int j,char [][]matrix){
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(matrix[i][j]=='0') return dp[i][j]=0;

        int up=solve(i-1,j,matrix);
        int left=solve(i,j-1,matrix);
        int dig=solve(i-1,j-1,matrix);

        return dp[i][j]=1+Math.min(up,Math.min(left,dig));
    }
}