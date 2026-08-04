class Solution {
    Map<Integer,List<Integer>> graph=new HashMap<>();
    Set<Integer> set=new HashSet<>();
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        for(int []e:edges){
            int u=e[0];
            int v=e[1];
            graph.computeIfAbsent(u,k->new ArrayList<>()).add(v);
            graph.computeIfAbsent(v,k->new ArrayList<>()).add(u);
        }

        return dfs(source,destination);
    }

    public boolean dfs(int source,int destination){
        if(source==destination) return true;
        set.add(source);

        for(int n:graph.getOrDefault(source, new ArrayList<>())){
            if(!set.contains(n)){
                if(dfs(n,destination)) return true;
            }
        }
        return false;
    }
}