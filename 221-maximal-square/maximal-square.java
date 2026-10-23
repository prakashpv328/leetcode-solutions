class Solution {
    int dp[][];
    int m,n;
    public int maximalSquare(char[][] matrix) {
        this.m=matrix.length;
        this.n=matrix[0].length;

        dp=new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                ans=Math.max(ans,solve(i,j,matrix));
            }
        }

        return ans*ans;
    }

    private int solve(int i,int j,char [][]matrix){
        if(i<0 || j<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(matrix[i][j]=='0') return dp[i][j]=0;

        int up=solve(i-1,j,matrix);
        int left=solve(i,j-1,matrix);
        int dig=solve(i-1,j-1,matrix);

        return dp[i][j]=1+Math.min(up,Math.min(left,dig));
    }
}