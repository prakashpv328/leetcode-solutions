class Solution {
    public int[][] highestPeak(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int [][]vis=new int[m][n];
        int [][]ans=new int[m][n];
        Queue<int[]> queue=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(mat[i][j]==1){
                    vis[i][j]=1;
                    queue.add(new int[]{i,j,0});
                }
            }
        }

        int [][]dir={{0,-1},{0,1},{1,0},{-1,0}};

        while(!queue.isEmpty()){
            int size=queue.size();
            for(int k=0;k<size;k++){
                int []arr=queue.poll();
                int i=arr[0];
                int j=arr[1];
                int step=arr[2];

                ans[i][j]=step;

                for(int x=0;x<4;x++){
                    int row=i+dir[x][0];
                    int col=j+dir[x][1];

                    if(row>=0 && row<m && col>=0 && col<n && vis[row][col]==0){
                        vis[row][col]=1;
                        queue.add(new int[]{row,col,step+1});
                    }
                }
            }
        }
        return ans;
    }
}