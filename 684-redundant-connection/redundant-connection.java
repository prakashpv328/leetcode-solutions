class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int l=edges.length;
        DisjointSet ds=new DisjointSet(l+1);
        for(int []e:edges){
            if(ds.find(e[0])==ds.find(e[1])){
                return e;
            }
            ds.union(e[0],e[1]);
        }
        return new int[]{};
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

    public int find(int node){
        if(parent[node]==node){
            return node;
        }
        return parent[node]=find(parent[node]);
    }

    public void union(int u,int v){
        int rootU=find(u);
        int rootV=find(v);
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