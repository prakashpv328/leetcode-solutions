class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char k='1';k<='9';k++){
                        if(isValid(board,i,j,k)){
                            board[i][j]=k;
                            if(solve(board)){
                                return true;
                            }
                            else{
                                board[i][j]='.';
                            }
                        }

                    }
                    return false; 
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board,int r,int c,char n){
        for(int i=0;i<9;i++){
            if(board[r][i]==n && i!=c) return false;
        }
        for(int i=0;i<9;i++){
            if(board[i][c]==n && i!=r) return false;
        }
        int a=r/3;
        int b=c/3;
        int x,y;
        for(int i=0;i<9;i++){
             x=a*3+i/3;
             y=b*3+i%3;
            if(board[x][y]==n && x!=r && y!=c){
                return false;
            }
        }
        return true;
    }
}