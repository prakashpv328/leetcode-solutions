class Solution {
    public boolean isBipartite(int[][] graph) {
        int m=graph.length;
        int n=graph[0].length;
        int []color=new int[m];
        Arrays.fill(color,-1);

        for(int i=0;i<m;i++){
            if(color[i]==-1 && !dfs(i,0,color,graph)){
                return false;
            }
        }
        return true;
    }

    boolean dfs(int node,int c,int []color,int [][]graph){
        color[node]=c;
        for(int n:graph[node]){
            if(color[n]==-1){
                if(!dfs(n,1-c,color,graph)) return false;
            }
            else if(color[n]==color[node]){
                return false;
            }
        }
        return true;
    }
}