class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1) return -1;
        Deque<int[]> q=new ArrayDeque<>();
        q.offer(new int[]{0,0,1});
        int [][]dir={{-1,0},{0,1},{1,0},{0,-1},{-1,-1},{1,1},{-1,1},{1,-1}};
        while(!q.isEmpty()){
            int s=q.size();
            for(int i=0;i<s;i++){
                int []arr=q.poll();
                int r=arr[0];
                int c=arr[1];
                int w=arr[2];
                if(r==m-1 && c==n-1) return w;
                for(int x=0;x<8;x++){
                    int nr=r+dir[x][0];
                    int nc=c+dir[x][1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]==0){
                        q.add(new int[]{nr,nc,w+1});
                        grid[nr][nc]=1;
                    }
                }
            }


        }
        return -1;
    }
}