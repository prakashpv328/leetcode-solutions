class Solution {
    int ans=-1;
    public int longestCycle(int[] edges) {
        int l=edges.length;
        int []vis=new int[l];
        int []path=new int[l];
        for(int i=0;i<l;i++){
            if(vis[i]==0){
                dfs(i,edges,vis,path);
            }
        }
        return ans;
    }

    public void dfs(int node,int[] edges,int[] vis,int[] path){
        vis[node]=1;
        path[node]=1;
        int next=edges[node];
        if(next!=-1){
            if(vis[next]==0){
                dfs(next,edges,vis,path);
            }
            else if(path[next]!=0){
                int len=1;
                int curr=next;
                while(curr!=node){
                    curr=edges[curr];
                    len++;
                }
                ans=Math.max(ans,len);
            }
        }
        path[node]=0;
    }
}