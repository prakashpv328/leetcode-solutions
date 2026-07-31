class Solution {
    public String reorganizeString(String s) {
        int l=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->b[1]-a[1]);

        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(char c:map.keySet()){
            pq.offer(new int[]{c,map.get(c)});
        }

        StringBuilder sb=new StringBuilder();
        int [] prev=new int[]{'#',0};

        while(!pq.isEmpty()){
            int[] cur=pq.poll();
            sb.append((char)cur[0]);
            if(prev[1]>0) pq.offer(prev);
            cur[1]--;
            prev=cur;
        }
        return sb.length()==s.length()?sb.toString():"";
    }
}