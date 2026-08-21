class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int l=groupSizes.length;
        List<List<Integer>> list=new ArrayList<>();
        Map<Integer,List<Integer>> map=new HashMap<>();
        for(int i=0;i<l;i++){
            int val=groupSizes[i];
            map.putIfAbsent(val,new ArrayList<>());
            List<Integer> lst=map.get(val);

            lst.add(i);
            if(lst.size()==val){
                list.add(lst);
                map.put(val,new ArrayList<>());
            }
        }
        return list;
    }
}
