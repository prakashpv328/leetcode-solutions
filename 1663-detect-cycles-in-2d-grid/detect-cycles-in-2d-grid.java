class Solution {
    public boolean containsCycle(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int vis[][]=new int[m][n];
        int path[][]=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0 && dfs(i,j,-1,-1,grid,vis,grid[i][j])){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(int r ,int c,int i,int j,char[][] grid,int [][]vis,char ch){
        vis[r][c]=1;
        int m=grid.length;
        int n=grid[0].length;
        int[][] dir={{-1,0},{0,1},{1,0},{0,-1}};
        for(int x=0;x<4;x++){
            int nr=r+dir[x][0];
            int nc=c+dir[x][1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==ch){
                if(nr==i && nc==j) continue;
                if(vis[nr][nc]==0){
                    if(dfs(nr,nc,r,c,grid,vis,grid[nr][nc]))
                    return true;
                }
                else{
                    return true;
                }
            }
        }
        return false;
    }
}