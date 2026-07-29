class Solution {
    public String frequencySort(String s) {
        int l=s.length();
        Map<Character,Integer> map=new HashMap<>();
        PriorityQueue<Character> pq=new PriorityQueue<>(
            (a,b)-> map.get(b)-map.get(a)
        );
        for(char ch:s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        for(char ch:map.keySet()){
            pq.offer(ch);
        }
        StringBuilder str =new StringBuilder();
        while(!pq.isEmpty()){
            char c=pq.poll();
            for(int i=0;i<map.get(c);i++){
                str.append(c);
            }
        }
        return str.toString();

    }
}