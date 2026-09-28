class Solution {
    int n;
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        this.n=grid.length;
        dp=new int[n][n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-2);
            }
        }


        return Math.max(0,solve(0,0,0,grid));
    }

    private int solve(int r1,int c1,int r2,int[][] grid){
        int c2=r1+c1-r2;

        if(r1>= n || r2>= n || c1>=n || c2>=n){
            return -1;
        }

        if(dp[r1][c1][r2]!=-2) return dp[r1][c1][r2];

        if(grid[r1][c1]==-1 || grid[r2][c2]==-1) return -1;

        if(r1==n-1 && c1==n-1) return grid[r1][c1];

        int cherries=grid[r1][c1];
        if(r1!=r2 || c1!=c2) cherries+=grid[r2][c2];

        int value=-1;

        value=Math.max(value,solve(r1+1,c1,r2+1,grid));

        value=Math.max(value,solve(r1+1,c1,r2,grid));

        value=Math.max(value,solve(r1,c1+1,r2+1,grid));

        value=Math.max(value,solve(r1,c1+1,r2,grid));

        if(value==-1) return dp[r1][c1][r2]=value;

        return dp[r1][c1][r2]=value+cherries;
    }
}