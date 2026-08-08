class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int j=0;
        for(char c:s.toCharArray()){
            map.put(c,j++);
        }
        List<Integer> ans=new ArrayList<>();
        int prev=-1;
        int max=0;
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            max=Math.max(max,map.get(c));
            if(max==i){
                ans.add(max-prev);
                prev=max;
            }
        }
        return ans;
    }
}