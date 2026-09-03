class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        int l=edges.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int ans=Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int []dis=new int[n];
            int []par=new int[n];
            Arrays.fill(dis,-1);
            Arrays.fill(par,-1);

            Queue<Integer> queue=new ArrayDeque<>();
            queue.add(i);
            dis[i]=0;

            while(!queue.isEmpty()){
                int node=queue.poll();
                for(int nei:adj.get(node)){
                    if(dis[nei]==-1){
                        dis[nei]=dis[node]+1;
                        par[nei]=node;
                        queue.add(nei);
                    }
                    else if(par[node]!=nei){
                        int len=dis[node]+dis[nei]+1;
                        ans=Math.min(len,ans);
                    }  
                }
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}