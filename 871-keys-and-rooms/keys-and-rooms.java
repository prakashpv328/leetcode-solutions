class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int l=rooms.size();
        int []vis=new int[l];
        Queue<Integer> q=new LinkedList<>();
        vis[0]=1;
        q.offer(0);
        while(!q.isEmpty()){
            int a=q.poll();
            for(int i:rooms.get(a)){
                if(vis[i]==0){
                    vis[i]=1;
                    q.add(i);
                }
            }
        }
        for(int i=0;i<l;i++) if(vis[i]==0) return false;
        return true;
    }
}