class Solution {
    public boolean canReach(int[] arr, int start) {
        int n=arr.length;
        Queue<Integer> queue=new LinkedList<>();
        int vis[]=new int[n];
        queue.offer(start);
        while(!queue.isEmpty()){
            int idx=queue.poll();
            if(idx<0 || idx>=n || vis[idx]==1) continue;
            if(arr[idx]==0) return true;
            vis[idx]=1;
            queue.offer(idx+arr[idx]);
            queue.offer(idx-arr[idx]);
        }
        return false;
    }
}