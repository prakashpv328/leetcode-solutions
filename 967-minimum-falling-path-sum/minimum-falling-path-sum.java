class Solution {
    int n,m;
    int [][]dp;
    int ans=Integer.MAX_VALUE;
    public int minFallingPathSum(int[][] matrix) {
        this.m=matrix.length;
        this.n=matrix[0].length;
        dp=new int[m][n];

        for(int i=0;i<m;i++)
        Arrays.fill(dp[i],Integer.MAX_VALUE);

        for(int i=0;i<n;i++){
            ans=Math.min(solve(matrix,0,i),ans);
        }

        return ans;
    }

    private int solve(int[][] matrix,int r,int c){
        if(r==m-1) return matrix[r][c];
        if(dp[r][c]!=Integer.MAX_VALUE) return dp[r][c];
        int down=solve(matrix,r+1,c);
        int left=Integer.MAX_VALUE,right=Integer.MAX_VALUE;
        if(c-1>=0)
        left=solve(matrix,r+1,c-1);
        if(c+1<n)
        right=solve(matrix,r+1,c+1);

        int min=Math.min(down,Math.min(left,right));

        return dp[r][c]=min+matrix[r][c];
    }
}