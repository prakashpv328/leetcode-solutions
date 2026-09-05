class Solution {
    int m,n;
    int [][]dir={{-1,0},{0,1},{1,0},{0,-1}};
    int dp[][];
    public int longestIncreasingPath(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int num=0;
        int ans=0;

        dp=new int[m][n]; 
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                num=dfs(i,j,matrix,dp);
                ans=Math.max(num,ans);
            }
        }
        return ans;
    }

    public int dfs(int r,int c,int [][]matrix,int[][] dp){
        if(dp[r][c]!=0){
            return dp[r][c];
        }
        int m=matrix.length;
        int n=matrix[0].length;
        
        int num=0;
        for(int x=0;x<4;x++){
            int nr=r+dir[x][0];
            int nc=c+dir[x][1];
            if(nr>=0 && nr<m && nc>=0 && nc<n && matrix[nr][nc]>matrix[r][c]){
                num=Math.max(num,dfs(nr,nc,matrix,dp));
            }
        }
        dp[r][c]=1+num;
        return dp[r][c];
    }
}