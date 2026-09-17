class Solution {
    public boolean equationsPossible(String[] equations) {
        DisjointSet ds=new DisjointSet(26);

        for(String s:equations){
            if(s.charAt(1)=='='){
                int u=s.charAt(0)-'a';
                int v=s.charAt(3)-'a';
                int pu=ds.find(u);
                int pv=ds.find(v);
                if(pu!=pv) ds.union(u,v);
            }
        }

        for(String s:equations){
            if(s.charAt(1)=='!'){
                int u=s.charAt(0)-'a';
                int v=s.charAt(3)-'a';
                int pu=ds.find(u);
                int pv=ds.find(v);
                if(pu==pv) return false;
            }
        }
        return true;
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