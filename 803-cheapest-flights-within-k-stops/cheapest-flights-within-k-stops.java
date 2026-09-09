class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int l=flights.length;
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int[][] dist = new int[n][k + 2];

        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        for(int []f:flights){
            adj.get(f[0]).add(new int[]{f[1],f[2]});
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{src,0,0});
        while(!pq.isEmpty()){
            int arr[]=pq.poll();
            int node=arr[0];
            int amount=arr[1];
            int turn=arr[2];
            if(node==dst){
                return amount;
            }
            if(turn==k+1){
                continue;
            }
            for(int []next:adj.get(node)){
                int nextNode=next[0];
                int nextPrice=next[1]+amount;
                int nextTurn=turn+1;
                if(nextPrice<dist[nextNode][nextTurn]){
                    dist[nextNode][nextTurn]=nextPrice;
                    pq.offer(new int[]{nextNode,nextPrice,nextTurn});
                }
            }
        }
        return -1;
    }
}