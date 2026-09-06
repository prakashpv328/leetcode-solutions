class Solution {
    long ans;
    int m,n;
    int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
    int MOD = 1_000_000_007;
    public int countPaths(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans+=dfs(i,j,grid,dp);
                ans%=MOD;
            }
        }
        return (int)ans;
    }
    private int dfs(int r,int c,int[][] grid,int [][]dp){
        if(dp[r][c]!=0){
            return dp[r][c];
        }
        long count=1;
        for(int x=0;x<4;x++){
            int nr=r+dir[x][0];
            int nc=c+dir[x][1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]>grid[r][c]){
                count+=dp[r][c]=dfs(nr,nc,grid,dp);
                count%=MOD;
            }
        }
        return dp[r][c]=(int)count;
    }
}