class Solution {
    int timer=0;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> con:connections){
            int u=con.get(0);
            int v=con.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vis[]=new int[n];
        int t[]=new int[n];
        int low[]=new int[n];
        List<List<Integer>> ans=new ArrayList<>();
        dfs(0,-1,adj,vis,t,low,ans);
        return ans;
    }

    private void dfs(int node,int parent,List<List<Integer>> adj,int[] vis,int[] t,int[] low,List<List<Integer>> ans){
        vis[node]=1;
        low[node]=t[node]=timer;
        timer++;

        for(int next:adj.get(node)){
            if(parent==next) continue;
            if(vis[next]==0){
                dfs(next,node,adj,vis,t,low,ans);
                low[node]=Math.min(low[node],low[next]);
                if(t[node]<low[next]){
                    ans.add(Arrays.asList(node,next));
                }
            }
            else{
                low[node]=Math.min(low[node],low[next]);
            }
        }
    }
}