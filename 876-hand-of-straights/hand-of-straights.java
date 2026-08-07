class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:hand){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(map.keySet());

        while(!pq.isEmpty()){
            int f=pq.peek();
            for(int i=0;i<groupSize;i++){
                int num=f+i;
                if(map.getOrDefault(num,0)==0){
                    return false;
                }
                map.put(num,map.getOrDefault(num,0)-1);
                if(map.get(num)==0){
                    pq.poll();
                }
            }
        }
        return true;
    }
}