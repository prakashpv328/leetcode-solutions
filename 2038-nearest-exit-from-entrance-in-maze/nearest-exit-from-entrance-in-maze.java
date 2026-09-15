class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m=maze.length;
        int n=maze[0].length;
        Deque<int[]> queue=new ArrayDeque<>();
        queue.offer(new int[]{entrance[0],entrance[1],0});
        maze[entrance[0]][entrance[1]]='+';
        int [][]dir={{-1,0},{0,1},{1,0},{0,-1}};
        while(!queue.isEmpty()){
            int []arr=queue.poll();
            int i=arr[0];
            int j=arr[1];
            int step=arr[2];
            for(int x=0;x<4;x++){
                int nr=i+dir[x][0];
                int nc=j+dir[x][1];
                if(nr>=0 && nr<m && nc>=0 && nc<n && maze[nr][nc]=='.'){
                    maze[nr][nc]='+';
                    if(nr==0 || nr==m-1 || nc==0 || nc==n-1 ) return step+1;
                    queue.offer(new int[]{nr,nc,step+1});
                }
            }
        }
        return -1;
    }
}