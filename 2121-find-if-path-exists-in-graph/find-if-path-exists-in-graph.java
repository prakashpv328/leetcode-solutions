class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int vis[]=new int[n];
        int l=edges.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        return dfs(n,edges,adj,vis,source,destination);
    }
    private boolean dfs(int n, int[][] edges,ArrayList<ArrayList<Integer>> adj,int vis[], int source, int destination){
        vis[source]=1;
        if(source==destination) return true;
        for(int node:adj.get(source)){
            if(vis[node]==0 && dfs(n,edges,adj,vis,node,destination)){
                return true;
            }
        }
        return false;
    }
}