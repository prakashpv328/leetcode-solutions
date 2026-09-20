class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet dsa=new DisjointSet(n+1);
        DisjointSet dsb=new DisjointSet(n+1);
        int remove=0;
        int a=n,b=n;
        for(int e[]:edges){
            if(e[0]==3){
                if(dsa.find(e[1])!=dsa.find(e[2])){
                    dsa.sUnion(e[1],e[2]);
                    dsb.sUnion(e[1],e[2]);
                    a--;
                    b--;
                }
                else{
                    remove++;
                }
            }
        }

        for(int e[]:edges){
            if(e[0]==1){
                if(dsa.find(e[1])!=dsa.find(e[2])){
                    dsa.sUnion(e[1],e[2]);
                    a--;
                }
                else{
                    remove++;
                }
            }
            else if(e[0]==2){
                if(dsb.find(e[1])!=dsb.find(e[2])){
                    dsb.sUnion(e[1],e[2]);
                    b--;
                }
                else{
                    remove++;
                }
            }
        }
        if(a!=1 || b!=1) return -1;
        return remove;
    }
}
class DisjointSet{
    int []parent;
    int []rank;
    int []size;
    DisjointSet(int n){
        parent=new int[n];
        rank=new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }

    int find(int u){
        if(parent[u]==u){
            return u;
        }
        return find(parent[u]);
    }

    void rUnion(int u,int v){
        int pu=find(u);
        int pv=find(v);

        if(rank[pu]>rank[pv]){
            parent[pv]=pu;
        }
        else if(rank[pv]>rank[pu]){
            parent[pu]=pv;
        }
        else{
            parent[pu]=pv;
            rank[pu]++;
        }
    }

    void sUnion(int u, int v) {
        int pu = find(u);
        int pv = find(v);

        if (pu == pv) {
            return;
        }

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } 
        else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}