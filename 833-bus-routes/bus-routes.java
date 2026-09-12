class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target) return 0;
        HashMap<Integer,List<Integer>> map=new HashMap<>();
        int l=routes.length;
        for(int i=0;i<l;i++){
            for(int stop:routes[i]){
                map.computeIfAbsent(stop,k->new ArrayList<>()).add(i);
            }
        }
        Queue<Integer> queue=new ArrayDeque<>();
        Set<Integer> set=new HashSet<>();
        boolean vis[]=new boolean[l];

        queue.add(source);
        int ans=0;

        while(!queue.isEmpty()){
            int size=queue.size();
            ans++;
            while(size-->0){
                int stop=queue.poll();
                for(int bus:map.getOrDefault(stop,new ArrayList<>())){
                    if(vis[bus]){
                        continue;
                    }
                    vis[bus]=true;
                    for(int next:routes[bus]){
                        if(next==target) return ans;
                        if(!set.contains(next)){
                            set.add(next);
                            queue.offer(next);
                        }
                    }
                }
            }
        }
        return -1;
    }
}