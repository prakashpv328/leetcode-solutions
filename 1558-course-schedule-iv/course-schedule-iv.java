class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
        boolean adj[][]=new boolean[n][n];
        for(int []pre:prerequisites){
            adj[pre[0]][pre[1]]=true;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    adj[i][j]=adj[i][j] || adj[i][k] && adj[k][j];
                }
            }
        }

        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<queries.length;i++){
            ans.add(adj[queries[i][0]][queries[i][1]]);
        }
        return ans;
    }
}