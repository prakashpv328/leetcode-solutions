class Solution {
    public int maxEvents(int[][] events) {
        int n=events.length;
        Arrays.sort(events,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int ans=0;
        int day=0;
        int i=0;

        while(i<n || !pq.isEmpty()){
            if(pq.isEmpty()){
                day=events[i][0];
            }
            while(i<n && events[i][0]==day){
                pq.offer(events[i][1]);
                i++;
            }
            while(!pq.isEmpty() && pq.peek()<day){
                pq.poll();
            }
            if(!pq.isEmpty()){
                pq.poll();
                day++;
                ans++;
            }
        }
        return ans;
    }
}