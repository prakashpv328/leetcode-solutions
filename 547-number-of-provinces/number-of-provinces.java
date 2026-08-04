class Solution {
    boolean[] visit;
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int ans=0;
        visit =new boolean[n];

        for(int i=0;i<n;i++){
            if(!visit[i]){
                dfs(i,isConnected);
                ans++;
            }
        }
    return ans;
    }

    public void dfs(int node,int[][] isConnected){
        visit[node]=true;
        for(int i=0;i<isConnected.length;i++){
            if(!visit[i] && isConnected[node][i]==1){
                dfs(i,isConnected);
            }
        }
    }
}