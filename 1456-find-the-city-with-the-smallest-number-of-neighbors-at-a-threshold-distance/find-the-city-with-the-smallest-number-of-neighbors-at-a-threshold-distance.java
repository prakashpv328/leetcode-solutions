class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int dis[][]=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dis[i],10001);
            dis[i][i]=0;
        }
        for(int e[]:edges){
           dis[e[0]][e[1]]=e[2];
           dis[e[1]][e[0]]=e[2];
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dis[i][j]=Math.min(dis[i][j],dis[i][k]+dis[k][j]);
                }
            }
        }


        int min=n;
        int ans=-1;
        for(int i=0;i<n;i++){
            int reach=0;
            for(int j=0;j<n;j++){
                if(dis[i][j]<=distanceThreshold){
                    reach++;
                }
            }
            if(reach<=min){
                min=reach;
                ans=i;
            }
        }
        return ans;
    }
}