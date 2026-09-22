class Solution {
    int dp[][];
    int ans=Integer.MAX_VALUE,m,n;
    int dir[][]={{0,1},{1,0}};
    public int minPathSum(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        dp=new int[m][n];
        for(int i=0;i<m;i++)
        Arrays.fill(dp[i],-1);
        return solve(0,0,grid);
    }
    int solve(int i,int j,int[][] grid){
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int num=Integer.MAX_VALUE;
        for(int x=0;x<2;x++){
            int nr=i+dir[x][0];
            int nc=j+dir[x][1];
           
            if(nr>=0 && nr<m && nc>=0 && nc<n){
                num=Math.min(solve(nr,nc,grid),num);
            }
        }

        return dp[i][j] = grid[i][j] + num;
    }
}