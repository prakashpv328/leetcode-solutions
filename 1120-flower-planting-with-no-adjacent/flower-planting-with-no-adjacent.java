class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []p:paths){
            adj.get(p[0]-1).add(p[1]-1);
            adj.get(p[1]-1).add(p[0]-1);
        }
        int []ans=new int[n];
        int l=paths.length;
        for(int i=0;i<n;i++){
            boolean []used=new boolean[5];
            for(int node:adj.get(i)){
                if(ans[node]!=0){
                    used[ans[node]]=true;
                }
            }
            for(int j=1;j<=4;j++){
                if(!used[j]){
                    ans[i]=j;
                    break;
                }
            }
        }
        return ans;
    }
}