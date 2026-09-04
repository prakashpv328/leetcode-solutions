class Solution {
    int ans=0;
    public int countBattleships(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='X'){
                    ans++;
                    dfs(board,i,j);
                }
            }
        }
        return ans;
    }
    private void dfs(char[][] board,int r,int c){
        board[r][c]='.';
        int m=board.length;
        int n=board[0].length;

        int [][]dir={{-1,0},{0,1},{1,0},{0,-1}};
        for(int x=0;x<4;x++){
            int nr=r+dir[x][0];
            int nc=c+dir[x][1];

            if(nr>=0 && nr<m && nc>=0 && nc<n && board[nr][nc]=='X'){
                dfs(board,nr,nc);
            }
        }
    }
}