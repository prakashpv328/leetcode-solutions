class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);

        for(int p:piles){
            pq.add(p);
        }

        while(k-->0){
            pq.add(pq.peek()-pq.poll()/2);
        }
        int ans=0;
        while(!pq.isEmpty()){
            ans+=pq.poll();
        }
        return ans;
    }
}