class Solution {
    int dp[][];
    int n;
    public int minimumTotal(List<List<Integer>> triangle) {
        this.n=triangle.size();
        dp=new int[n][n];

        for(int i=0;i<n;i++){
            dp[n-1][i]=triangle.get(n-1).get(i);
        }

        int right=0,left=0;

        for(int i=n-2;i>=0;i--){
            for(int j=i;j>=0;j--){
                right=dp[i+1][j+1];
                left=dp[i+1][j];
                dp[i][j]=triangle.get(i).get(j)+Math.min(right,left);
            }
        }

        return dp[0][0];
    }

    // private int solve(int r,int c,List<List<Integer>> list){
    //     if(r==n-1){
    //         return dp[r][c]=list.get(r).get(c);
    //     }

    //     if(dp[r][c]!=-1) return dp[r][c];

    //     int right=solve(r+1,c+1,list);
    //     int left=solve(r+1,c,list);

    //     return dp[r][c]=(list.get(r).get(c)+Math.min(right,left));
    // }
}