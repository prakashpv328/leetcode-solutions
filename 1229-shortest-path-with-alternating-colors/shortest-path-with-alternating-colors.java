class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<List<Integer>> red=new ArrayList<>();
        List<List<Integer>> blue=new ArrayList<>();
        for(int i=0;i<n;i++){
            red.add(new ArrayList<>());
            blue.add(new ArrayList<>());
        }
        for(int r[]:redEdges){
            red.get(r[0]).add(r[1]);
        }
        for(int b[]:blueEdges){
            blue.get(b[0]).add(b[1]);
        }

        int ans[]=new int[n];
        Arrays.fill(ans,-1);

        Queue<int[]> q=new LinkedList<>();
        int vis[][]=new int[n][2];

        q.add(new int[]{0,0});
        q.add(new int[]{0,1});
        vis[0][0]=1;
        vis[0][1]=1;
        ans[0]=0;
        int distance=0;

        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int arr[]=q.poll();
                int node=arr[0];
                int color=arr[1];

                int nextColor=1-color;
                List<Integer> list;

                if(nextColor==0){
                    list=red.get(node);
                }
                else{
                    list=blue.get(node);
                }
                // System.out.print(list);
                for(int next:list){
                    if(vis[next][nextColor]==1) continue;
                    vis[next][nextColor]=1;
                    if(ans[next]==-1){
                        ans[next]=distance+1;
                    }
                    q.offer(new int[]{next,nextColor});
                }
            }
            distance++;
        }

        return ans;
    }
}