class Solution {
    int n;
    int []ans;
    List<List<Integer>> adj;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        n=quiet.length;
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int r[]:richer){
            adj.get(r[1]).add(r[0]);
        }
        ans=new int[n];
        Arrays.fill(ans,-1);

        for(int i=0;i<n;i++){
            dfs(i,quiet);
        }
        return ans;
    }

    private int dfs(int node,int[] quite){
        if(ans[node]!=-1){
            return ans[node];
        }
        ans[node]=node;
        for(int nei:adj.get(node)){
            int next=dfs(nei,quite);
            if(quite[next]<quite[ans[node]]){
                ans[node]=next;
            }
        }
        return ans[node];
    }
}