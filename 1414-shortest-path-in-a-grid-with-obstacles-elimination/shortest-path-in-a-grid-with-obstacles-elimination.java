class Solution {
    int ans=Integer.MAX_VALUE;
    int m,n;
    public int shortestPath(int[][] grid, int k) {
        this.m=grid.length;
        this.n=grid[0].length;
        int [][]vis=new int[m][n];
        for(int []r:vis){
            Arrays.fill(r,-1);
        }
        Queue<int[]> queue=new ArrayDeque<>();
        queue.offer(new int[]{0,0,k,0});
        int [][]dir={{-1,0},{0,1},{1,0},{0,-1}};

        while(!queue.isEmpty()){
            int []arr=queue.poll();
            int r=arr[0];
            int c=arr[1];
            int rk=arr[2];
            int step=arr[3];

            if(r==m-1 && c==n-1){
                return step;
            }
            for(int []d:dir){
                int nr=r+d[0];
                int nc=c+d[1];

                if(nr<0 || nr>=m || nc<0 || nc>=n){
                    continue;
                }
                int nk=rk-grid[nr][nc];
                if(rk<0) continue;

                if(nk>vis[nr][nc]){
                    vis[nr][nc]=nk;
                    queue.offer(new int[]{nr,nc,nk,step+1});
                }
            }
        }

        return ans==Integer.MAX_VALUE?-1:ans;
    }
}