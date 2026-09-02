class Solution {
    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        int l=roads.length;
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []r:roads){
            int u=r[0];
            int v=r[1];
            int w=r[2];

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(1);
        int []vis=new int[n+1];
        vis[1]=1;
        int ans=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int q=queue.poll();
            for(int arr[]:adj.get(q)){
                int v=arr[0];
                int w=arr[1];
                ans=Math.min(ans,arr[1]);
                if(vis[v]==0){
                    queue.offer(v);
                    vis[v]=1;
                }
            }
        }
        return ans;
    }
}