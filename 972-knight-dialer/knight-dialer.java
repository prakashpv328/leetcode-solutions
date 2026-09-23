class Solution {
    int dir[][]={{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2}};
    int [][]grid={{1,2,3},{4,5,6},{7,8,9},{-1,0,-1}};
    int [][][]dp;
    int num;
    int MOD = 1000000007;
    public int knightDialer(int num) {
        this.num=num;
        long ans=0;

        dp=new int[4][3][num];

        for(int i=0;i<4;i++)
            for(int j=0;j<3;j++)
                Arrays.fill(dp[i][j],-1);


        for(int i=0;i<4;i++){
            for(int j=0;j<3;j++){
                if(grid[i][j]!=-1){
                    ans+=solve(i,j,1);
                    ans=ans%MOD;
                }
            }
        }

        return (int)ans;
    }
    private int solve(int r,int c,int count){
        if(count==num){
            return 1;
        }
        if(dp[r][c][count]!=-1) return dp[r][c][count];
        long tot=0;
        for(int x=0;x<8;x++){
            int nr=r+dir[x][0];
            int nc=c+dir[x][1];
            if(nr>=0 && nr<4 && nc>=0 && nc<3 && grid[nr][nc]!=-1)
                tot+=solve(nr,nc,count+1);
                tot=tot%MOD;
        }
        return dp[r][c][count]=(int)tot;
    }
}