class Solution {
    public int makeConnected(int n, int[][] connections) {
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<connections.length;i++){
            ds.unionByRank(connections[i][0],connections[i][1]);
        }
        int com=0;
        for(int i=0;i<n;i++){
            if(ds.parent[i]==i){
                com++;
            }
        }
        if(connections.length<(n-1)) return -1;
        return com-1;
    }
}

class DisjointSet{
    int []parent;
    int []rank;
    DisjointSet(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
    }

    public int findUPar(int node){
        if(parent[node]==node){
            return node;
        }
        return parent[node]=findUPar(parent[node]);
    }

    public void unionByRank(int u,int v){
        int rootU=findUPar(u);
        int rootV=findUPar(v);
        if(rank[rootU]<rank[rootV]){
            parent[rootU]=rootV;
        }
        else if(rank[rootU]>rank[rootV]){
            parent[rootV]=rootU;
        }
        else{
            parent[rootV]=rootU;
            rank[rootU]++;
        }
    }
}