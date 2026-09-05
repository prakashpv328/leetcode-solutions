class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int l=edges.length;
        if(n==1) return new ArrayList<>(Arrays.asList(0));
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int []degree=new int[n];
        for(int e[]:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
            degree[e[0]]++;
            degree[e[1]]++;
        }

        Queue<Integer> queue=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(degree[i]==1){
                queue.add(i);
            }
        }

        int tot=n;

        while(tot>2){
            int s=queue.size();
            tot-=s;
            for(int i=0;i<s;i++){
                int q=queue.poll();

                for(int node:adj.get(q)){
                    degree[node]--;
                    if(degree[node]==1){
                        queue.offer(node);
                    }
                }
            }
        }
        
        List<Integer> list=new ArrayList<>(queue);
        return list;
    }
}