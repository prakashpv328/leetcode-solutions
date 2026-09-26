class Solution {
    int dp[][];
    int m,n;
    int ans=Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        dp=new int[m][n];
        for(int i=0;i<m;i++)
        Arrays.fill(dp[i],1000);

        for(int i=0;i<n;i++){
            ans=Math.min(solve(grid,0,i),ans);
        }
        return ans;
    }

    private int solve(int[][] grid,int r,int c){
        if(r==m-1) return grid[r][c];
        if(dp[r][c]!=1000) return dp[r][c];
        int num=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(i!=c){
                num=Math.min(solve(grid,r+1,i),num);
            }
        }
        return dp[r][c]=num+grid[r][c];
    }
}
