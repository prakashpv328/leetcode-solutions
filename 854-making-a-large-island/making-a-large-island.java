class Solution {
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds=new DisjointSet(n*n);

        int [][]dir={{-1,0},{0,1},{1,0},{0,-1}};

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0) continue;
                for(int x=0;x<4;x++){
                    int nr=i+dir[x][0];
                    int nc=j+dir[x][1];
                    if(nr>=0 && nr<n && nc>=0 && nc<n && grid[nr][nc]==1){
                        int curr=i*n+j;
                        int next=nr*n+nc;
                        ds.sUnion(curr,next);
                    }
                }
            }
        }

        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) continue;
                Set<Integer> set=new HashSet<>();
                for(int x=0;x<4;x++){
                    int nr=i+dir[x][0];
                    int nc=j+dir[x][1];
                    if(nr>=0 && nr<n && nc>=0 && nc<n){
                        if(grid[nr][nc]==1){
                            set.add(ds.find(nr*n+nc));
                        }
                    }
                }

                int size=0;
                for(Integer p:set){
                    size+=ds.size[p];
                }
                max=Math.max(max,size+1);
            }
        }
        for(int i=0;i<n*n;i++){
            max=Math.max(max,ds.size[ds.find(i)]);
        }
        return  max;
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