class Solution {
    int m;
    int n;
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        dp=new int[m][n][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(0,0,n-1,grid);
    }

    private int solve(int r,int j1,int j2,int [][]grid){
        if(j1<0 || j1>=n || j2<0 || j2>=n) return Integer.MIN_VALUE;

        if(dp[r][j1][j2]!=-1) return dp[r][j1][j2];

        if(r==m-1){
            if(j1==j2) return grid[r][j1];
            else return grid[r][j1]+grid[r][j2];
        }
        int max=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int val=0;
                if(j1==j2) val=grid[r][j1];
                else val=grid[r][j1]+grid[r][j2];
                val+=solve(r+1,j1+i,j2+j,grid);
                max=Math.max(max,val);
            }
        }
        return dp[r][j1][j2]=max;
    }
}