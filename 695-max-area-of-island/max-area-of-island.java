class Solution {
    int ans=0;
    int m;
    int n;
    public int maxAreaOfIsland(int[][] grid) {
        this.m=grid.length;
        this.n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    ans=Math.max(ans,dfs(grid,i,j));
                }
            }
        }
        return ans;
    }
    private int dfs(int[][] grid,int r,int c){
        grid[r][c]=0;
        int [][]dir={{-1,0},{0,1},{1,0},{0,-1}};
        int step=1;
        for(int x=0;x<4;x++){
            int nr=r+dir[x][0];
            int nc=c+dir[x][1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==1){
                step+=dfs(grid,nr,nc);
            }
        }
        return step;
    }
}