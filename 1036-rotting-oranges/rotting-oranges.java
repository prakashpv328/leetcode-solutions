class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        int tf=0,tr=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    tr++;
                    q.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    tf++;
                }
            }
        }

        if(tf==0) return 0;
        if(q.isEmpty()) return -1;


        int [][]dirs={{-1,0},{0,-1},{1,0},{0,1}};
        int ans=-1;
        while(!q.isEmpty()){
            int s=q.size();
            for(int k=0;k<s;k++){
                int []data=q.poll();
                int x=data[0];
                int y=data[1];

                for(int []d:dirs){
                    int i=x+d[0];
                    int j=y+d[1];
                    if(i>=0 && i<m && j>=0 && j<n && grid[i][j]==1){
                        grid[i][j]=2;
                        tf--;
                        q.offer(new int[]{i,j});
                    }
                }
            }
            ans++;
        }
        return tf==0?ans:-1;
    }
}