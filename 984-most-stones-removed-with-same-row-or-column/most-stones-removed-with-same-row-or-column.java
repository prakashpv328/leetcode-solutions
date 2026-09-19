class Solution {
    public int removeStones(int[][] stones) {
        int m=0;
        int n=0;
        int l=stones.length;
        for(int i=0;i<l;i++){
            m=Math.max(m,stones[i][0]);
            n=Math.max(n,stones[i][1]);
        }
        DisjointSet ds=new DisjointSet(m+n+2);
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<l;i++){
            int row=stones[i][0];
            int col=stones[i][1]+m+1;
            ds.sUnion(row,col);
            map.put(row,1);
            map.put(col,1);
        }
        int com=0;
        for(Map.Entry<Integer,Integer> it:map.entrySet()){
            if(ds.find(it.getKey())==it.getKey()){
                com++;
            }
        }
        return l-com;
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