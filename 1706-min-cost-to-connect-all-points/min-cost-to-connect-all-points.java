class Solution {
    public int minCostConnectPoints(int[][] points) {
        int l=points.length;
        List<int[]> list=new ArrayList<>();
        for(int i=0;i<l;i++){
            for(int j=i+1;j<l;j++){
                int cost = Math.abs(points[i][0]-points[j][0])
                            + Math.abs(points[i][1]-points[j][1]);
                list.add(new int[]{i,j,cost});
            }
        }
        list.sort((a,b)->a[2]-b[2]);

        DisjointSet ds=new DisjointSet(l);
        int ans=0;
        int count=0;
        for(int []lst:list){
            int u=lst[0];
            int v=lst[1];
            int w=lst[2];

            if(ds.find(u)!=ds.find(v)){
                ds.sUnion(u,v);
                ans+=w;
                count++;
            }
            if(count==l-1) break;
        }
        return ans;
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