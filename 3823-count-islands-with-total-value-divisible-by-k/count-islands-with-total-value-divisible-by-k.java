class Solution {
    int vis[][];
    int m,n;
    int [][]dir={{-1,0},{0,1},{1,0},{0,-1}};
    public int countIslands(int[][] grid, int k) {
        this.m=grid.length;
        this.n=grid[0].length;

        vis=new int[m][n];

        int ans=0;


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0 && vis[i][j]==0){
                    long sum=solve(i,j,grid);
                    if(sum%k==0) ans+=1;
                }
            }
        }

        return ans;
    }

    private long solve(int i,int j,int [][]grid){
        vis[i][j]=1;

        long sum=0;

        for(int x=0;x<4;x++){
            int nr=i+dir[x][0];
            int nc=j+dir[x][1];


            if(nr<0 || nc<0 || nr>=m || nc>=n || vis[nr][nc]==1 || grid[nr][nc]==0){
                continue;
            }
            sum+=solve(nr,nc,grid);
        }

        return sum+grid[i][j];
    }
}