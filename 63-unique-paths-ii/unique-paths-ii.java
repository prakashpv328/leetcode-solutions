class Solution {
    int dp[][];
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        dp=new int[m][n];
        return solve(m-1,n-1,obstacleGrid);
    }

    private int solve(int i,int j,int [][]grid){
        if(i<0 || j<0 || grid[i][j]==1) return 0;
        if(i==0 && j==0) return 1;
        if(dp[i][j]!=0) return dp[i][j]; 
        int left=solve(i,j-1,grid);
        int up=solve(i-1,j,grid);
        return dp[i][j]=left+up;
    }
}