class Solution {

    public boolean dfs(List<List<Integer>> adj,int node,int[] vis,int[] path){
        vis[node]=1;
        path[node]=1;
        for(int x:adj.get(node)){
            if(vis[x]==0 && dfs(adj,x,vis,path)){
                return true;
            }
            else if(path[x]==1){
                return true;
            }
        }
        path[node]=0;
        return false;
    }



    public List<Integer> eventualSafeNodes(int[][] graph) {
        int l=graph.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<l;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<graph[i].length;j++){
                list.add(graph[i][j]);
            }
            adj.add(list);
        }

        int[] vis=new int[l];
        int[] path=new int[l];

        for(int i=0;i<l;i++){
            if(vis[i]==0){
                dfs(adj,i,vis,path);
            }
        }

        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<path.length;i++){
            if(path[i]==0){
                ans.add(i);
            }
        }
        return ans;
    }
}