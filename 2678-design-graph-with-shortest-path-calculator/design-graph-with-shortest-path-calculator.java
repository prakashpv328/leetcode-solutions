class Graph {
    int dis[][];
    int n;
    int INF = Integer.MAX_VALUE/2;
    public Graph(int n, int[][] edges) {
        this.n=n;
        dis=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dis[i],INF);
            dis[i][i]=0;
        }
        int l=edges.length;
        for(int e[]:edges){
            dis[e[0]][e[1]]=Math.min(dis[e[0]][e[1]],e[2]);
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                if (dis[i][k] == INF) continue;
                for(int j=0;j<n;j++){
                    if (dis[k][j] == INF) continue;
                    dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                }
            }
        }
    }
    
    public void addEdge(int[] edge) {
        int u=edge[0],v=edge[1],w=edge[2];
        if(dis[u][v]<=w) return;
        dis[u][v]=w;

        for(int i=0;i<n;i++){
             if (dis[i][u] == INF) continue;
            for(int j=0;j<n;j++){
                if (dis[v][j] == INF) continue;
                dis[i][j]=Math.min(dis[i][j],dis[i][u]+w+dis[v][j]);
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        return dis[node1][node2]!=INF?dis[node1][node2]:-1;
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */