class KthLargest {
    int k;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        pq=new PriorityQueue<>(k);
        for(int n:nums){
            if(pq.size()<k){
                pq.offer(n);
            }
            else if(n>pq.peek()){
                pq.offer(n);
                pq.poll();
            }
        }

    }
    
    public int add(int val) {
        if(pq.size()<k){
            pq.offer(val);
        }
        else if(val>pq.peek()){
            pq.offer(val);
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */