class Solution {
    int ans=0;
    int m;
    int n;
    int step=0;
    public int maxAreaOfIsland(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        int [][]vis=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && grid[i][j]==1){
                    this.step=1;
                    dfs(grid,vis,i,j);
                }
            }
        }
        return ans;
    }
    private void dfs(int[][] grid,int[][]vis,int r,int c){
        vis[r][c]=1;
        ans=Math.max(ans,this.step);
        int [][]dir={{-1,0},{0,1},{1,0},{0,-1}};
        for(int x=0;x<4;x++){
            int nr=r+dir[x][0];
            int nc=c+dir[x][1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && vis[nr][nc]==0 && grid[nr][nc]==1){
                this.step++;
                dfs(grid,vis,nr,nc);
            }
        }
    }
}