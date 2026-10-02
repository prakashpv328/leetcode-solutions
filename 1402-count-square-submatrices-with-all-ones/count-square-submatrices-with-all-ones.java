class Solution {
    int m;
    int n;
    int [][]dp;
    public int countSquares(int[][] matrix) {
        this.m=matrix.length;
        this.n=matrix[0].length;
        dp=new int[m][n];

        int ans=0;

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans+=solve(i,j,matrix);
            }
        }
        return ans;
    }

    private int solve(int r,int c,int [][]matrix){
        if(r==m || c==n){
            return 0;
        }

        if(dp[r][c]!=-1){
            return dp[r][c];
        }

        if(matrix[r][c]==0){
            return 0;
        }

        int down=solve(r+1,c,matrix);
        int right=solve(r,c+1,matrix);
        int diag=solve(r+1,c+1,matrix);

        dp[r][c]=1+Math.min(down,Math.min(right,diag));

        return dp[r][c];
    }
}