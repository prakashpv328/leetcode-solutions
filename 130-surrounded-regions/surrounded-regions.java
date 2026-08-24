class Solution {
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        int [][]vis=new int[m][n];

        for(int i=0;i<m;i++){
            if(vis[i][0]==0 && board[i][0]=='O'){
                dfs(vis,board,i,0);
            }
            if(vis[i][n-1]==0 && board[i][n-1]=='O'){
                dfs(vis,board,i,n-1);
            }
        }

        for(int i=0;i<n;i++){
            if(vis[0][i]==0 && board[0][i]=='O'){
                dfs(vis,board,0,i);
            }
            if(vis[m-1][i]==0 && board[m-1][i]=='O'){
                dfs(vis,board,m-1,i);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(vis[i][j]==0){
                    board[i][j]='X';
                }
            }
        }


    }

    void dfs(int[][] vis,char[][] board,int r,int c){
        vis[r][c]=1;
        int m=board.length;
        int n=board[0].length;
        int [][]dir={{-1,0},{1,0},{0,1},{0,-1}};
        for(int i=0;i<4;i++){
            int row=r+dir[i][0];
            int col=c+dir[i][1];
            if(row>=0 && row<m && col>=0 && col<n && vis[row][col]==0 && board[row][col]=='O'){
                dfs(vis,board,row,col);
            }
        }

    }
}