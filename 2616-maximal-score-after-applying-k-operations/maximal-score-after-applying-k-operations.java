class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans=0;
        int l=nums.length;
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);
        for(int i=0;i<l;i++){
            pq.offer(nums[i]);
        }
        while(k>0 && !pq.isEmpty()){
            int n=pq.poll();
            ans+=n;
            pq.offer((int)Math.ceil((double)n/3));
            // System.out.print(pq);
            k--;
        }
        return ans;
    }
}