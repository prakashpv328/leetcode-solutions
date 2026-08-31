class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int l=rooms.size();
        int []vis=new int[l];
        Queue<Integer> q=new LinkedList<>();
        for(int i:rooms.get(0)){
            q.offer(i);
            vis[0]=1;
        }
        while(!q.isEmpty()){
            int a=q.poll();
            vis[a]=1;
            for(int i:rooms.get(a)){
                if(vis[i]==0){
                    q.add(i);
                }
            }
        }
        for(int i=0;i<l;i++) if(vis[i]==0) return false;
        return true;
    }
}