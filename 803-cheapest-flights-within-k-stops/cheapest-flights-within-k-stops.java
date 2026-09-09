class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] f : flights){
            adj.get(f[0]).add(new int[]{f[1], f[2]});
        }

        // node, price, flights
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));

        int[][] dist = new int[n][k + 2];

        for(int i = 0; i < n; i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        dist[src][0] = 0;

        pq.offer(new int[]{src, 0, 0});

        while(!pq.isEmpty()){

            int[] curr = pq.poll();

            int node = curr[0];
            int price = curr[1];
            int flightsTaken = curr[2];

            if(node == dst){
                return price;
            }

            if(flightsTaken == k + 1){
                continue;
            }

            for(int[] next : adj.get(node)){

                int nextNode = next[0];
                int nextPrice = price + next[1];
                int nextFlights = flightsTaken + 1;

                // Only process if this is better
                if(nextPrice < dist[nextNode][nextFlights]){

                    dist[nextNode][nextFlights] = nextPrice;

                    pq.offer(new int[]{
                        nextNode,
                        nextPrice,
                        nextFlights
                    });
                }
            }
        }

        return -1;
    }
}