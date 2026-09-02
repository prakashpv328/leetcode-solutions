class Solution {
    int ans=0;
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> out=new ArrayList<>();
        List<List<Integer>> in=new ArrayList<>();
        for(int i=0;i<n;i++){
            out.add(new ArrayList<>());
            in.add(new ArrayList<>());
        }
        for(int []c:connections){
            out.get(c[0]).add(c[1]);
            in.get(c[1]).add(c[0]);
        }
        int []vis=new int[n];
        dfs(0,out,in,vis);
        return ans;
    }

    private void dfs(int i,List<List<Integer>> out,List<List<Integer>> in,int[] vis){
        vis[i]=1;
        for(int node:out.get(i)){
            if(vis[node]==0){
                ans++;
                dfs(node,out,in,vis);
            }
        }
        for(int node:in.get(i)){
            if(vis[node]==0){
                dfs(node,out,in,vis);
            }
        }
        vis[i]=0;
    }

}