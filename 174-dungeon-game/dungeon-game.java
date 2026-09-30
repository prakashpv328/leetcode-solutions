class Solution {
    int dp[][];
    int m,n;
    public int calculateMinimumHP(int[][] dungeon) {
        this.m=dungeon.length;
        this.n=dungeon[0].length;

        dp=new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);  
        }

        return solve(0,0,dungeon);
    }

    private int solve(int i,int j,int[][] arr){

        if(i==m-1 && j==n-1) return Math.max(1,1-arr[i][j]);

        if(dp[i][j]!=Integer.MAX_VALUE) return dp[i][j];

        int right=Integer.MAX_VALUE;    
        int down=Integer.MAX_VALUE;
        if(i+1<m)
        right=solve(i+1,j,arr);

        if(j+1<n)
        down=solve(i,j+1,arr);

        int need=Math.min(right,down);

        return dp[i][j]=Math.max(1,need-arr[i][j]);
    }
}