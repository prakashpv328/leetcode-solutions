class Solution {
    public int minJumps(int[] arr) {
        int l=arr.length;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<l;i++){
            map.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);
        }
        Queue<int[]> queue=new LinkedList<>();
        int vis[] =new int[l];
        queue.offer(new int[]{0,0});
        vis[0]=1;
        while(!queue.isEmpty()){
            int ar[]=queue.poll();
            int i=ar[0];
            int dis=ar[1];

            if(i==l-1) return dis;

            for(int node:map.get(arr[i])){
                if(vis[node]!=1){
                    vis[node]=1;
                    queue.offer(new int[]{node,dis+1});
                }
            }

            if(i>0 && vis[i-1]!=1){
                vis[i-1]=1;
                queue.offer(new int[]{i-1,dis+1});
            }
            if(i+1<l && vis[i+1]!=1){
                vis[i+1]=1;
                queue.offer(new int[]{i+1,dis+1});
            }
            map.get(arr[i]).clear();
        }
        return -1;
    }
}