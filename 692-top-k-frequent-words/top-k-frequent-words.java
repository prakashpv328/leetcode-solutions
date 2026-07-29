class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        PriorityQueue<String> pq=new PriorityQueue<>(
            (a,b)->{
                if(map.get(a).equals(map.get(b))){
                   return b.compareTo(a);
                }
                return map.get(a)-map.get(b);
            }
        );

        for(String s:words){
            map.put(s,map.getOrDefault(s,0)+1);
        }

        for(String s:map.keySet()){
            pq.offer(s);
            if(pq.size()>k){
                pq.poll();
            }
        }

        List<String> ans=new ArrayList<>();

        while(!pq.isEmpty()){
            ans.add(0,pq.poll());
        }
        return ans;
    }
}