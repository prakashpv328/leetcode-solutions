class Solution {
    public int countPaths(int n, int[][] roads) {
        int l=roads.length;
        int MOD = 1_000_000_007;
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []r:roads){
            adj.get(r[0]).add(new int[]{r[1],r[2]});
            adj.get(r[1]).add(new int[]{r[0],r[2]});
        }
        PriorityQueue<long[]> pq=new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        long dist[]=new long[n];
        int ways[]=new int[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        ways[0] = 1;
        dist[0] = 0;
        pq.offer(new long[]{0,0});
        while(!pq.isEmpty()){
            long arr[]=pq.poll();
            int node=(int)arr[0];
            long dis=arr[1];
            if (dis > dist[node]) {
                continue;
            }
            for(int []nei:adj.get(node)){
                int adjNode=nei[0];
                long adjT=nei[1];
                long newDist = dis + adjT;
                if(newDist==dist[adjNode]){
                    ways[adjNode] =(ways[adjNode] + ways[node]) % MOD;

                }
                if(newDist < dist[adjNode]){
                    ways[adjNode]=ways[node];
                    dist[adjNode]=newDist;
                    pq.offer(new long[]{adjNode,dist[adjNode]});
                }
            }

        }
        return ways[n-1];
    }
}