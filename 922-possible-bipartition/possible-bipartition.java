class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int l=dislikes.length;
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:dislikes){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int []color=new int[n+1];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i]==-1 && !dfs(i,0,color,adj)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node,int c,int[]color,List<List<Integer>> adj){
        color[node]=c;
        for(int n:adj.get(node)){
            if(color[n]==-1 && !dfs(n,1-c,color,adj)){
                return false;
            }
            else if(color[node]==color[n]) return false;
        }
        return true;
    }
}