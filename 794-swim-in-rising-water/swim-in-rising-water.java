class Solution {
    public int swimInWater(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[2]-b[2]);
        int [][]dis=new int[m][n];
        pq.offer(new int[]{0,0,grid[0][0]});
        int [][]dir={{-1,0},{0,1},{1,0},{0,-1}};
        dis[0][0]=grid[0][0];


        for(int i=0;i<m;i++){
            Arrays.fill(dis[i],Integer.MAX_VALUE);
        }
        while(!pq.isEmpty()){
            int arr[]=pq.poll();
            int r=arr[0];
            int c=arr[1];
            int w=arr[2];
            if(w>dis[r][c]){
                continue;
            }
            if(r==m-1 && c==n-1){
                return w;
            }
            for(int x=0;x<4;x++){
                int nr=r+dir[x][0];
                int nc=c+dir[x][1];
                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    int eff=Math.max(w,grid[nr][nc]);
                    if(eff<dis[nr][nc]){
                        dis[nr][nc]=eff;
                        pq.offer(new int[]{nr,nc,dis[nr][nc]});
                    }
                }
            }
        }
        return 0;
    }
}