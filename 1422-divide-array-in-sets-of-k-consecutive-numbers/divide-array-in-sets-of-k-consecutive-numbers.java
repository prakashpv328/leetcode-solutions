class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n=nums.length;
        // if(n)
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(map.keySet());

        while(!pq.isEmpty()){
            int f=pq.peek();
            for(int i=0;i<k;i++){
                int num=f+i;
                if(map.getOrDefault(num,0)==0){
                    return false;
                }
                map.put(num,map.getOrDefault(num,0)-1);
                if(map.get(num)==0){
                    if(num!=pq.peek()) return false;
                    pq.poll();
                }
            }
        }
        return true;
    }
}