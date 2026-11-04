class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;

        int [][]pre=new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                pre[i][j]=matrix[i-1][j-1]+pre[i-1][j]+pre[i][j-1]-pre[i-1][j-1];
            }
        }

        int ans=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                for(int r=i;r<m;r++){
                    for(int c=j;c<n;c++){
                        int sum=pre[r+1][c+1]-pre[r+1][j]-pre[i][c+1]+pre[i][j];

                        if(sum==target) ans++;
                    }
                }

            }
        }

        return ans;
    }
}