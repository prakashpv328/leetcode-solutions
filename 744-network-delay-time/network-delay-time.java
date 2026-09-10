class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int t[]:times){
            adj.get(t[0]).add(new int[]{t[1],t[2]});
        }
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int dist[]=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        pq.offer(new int[]{k,0});
        while(!pq.isEmpty()){
            int []arr=pq.poll();
            int node=arr[0];
            int dis=arr[1];
            for(int []nei:adj.get(node)){
                int neiNode=nei[0];
                int neiW=nei[1];
                if(dis+neiW<dist[neiNode]){
                    dist[neiNode]=dis+neiW;
                    pq.offer(new int[]{neiNode,dist[neiNode]});
                }
            }
        }
        int ans=0;
        // System.out.print(Arrays.toString(dist));
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans=Math.max(ans,dist[i]);
        }
        return ans;
    }
}