class Solution {
    Map<String,Integer> map;
    List<List<String>> ans;
    String begin;
    public List<List<String>> findLadders(String begin, String end, List<String> words) {
        Deque<String> queue=new ArrayDeque<>();
        Set<String> set=new HashSet<>(words);
        this.begin=begin;
        int len=words.size();
        queue.offer(begin);
        set.remove(begin);
        map=new HashMap<>();
        map.put(begin,0);
        while(!queue.isEmpty()){
            String str=queue.poll();
            int step=map.get(str);
            if(str.equals(end)) break;

            for(int i=0;i<str.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] chars=str.toCharArray();
                    chars[i]=ch;
                    String newStr=String.valueOf(chars);

                    if(set.contains(newStr)){
                        set.remove(newStr);
                        queue.offer(newStr);
                        map.put(newStr,step+1);
                    }
                }
            }
        }
        ans=new ArrayList<>();
        if(map.containsKey(end)){
            List<String> seq=new ArrayList<>();
            seq.add(end);
            dfs(end,seq);
        }
        return ans;
    }

    private void dfs(String word,List<String> seq){
        if(word.equals(begin)){
            List<String> temp=new ArrayList<>(seq);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        int step=map.get(word);
        for(int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                char[] chars=word.toCharArray();
                chars[i]=ch;
                String newStr=new String(chars);

                if(map.containsKey(newStr) && map.get(newStr)==step-1){
                    seq.add(newStr);
                    dfs(newStr,seq);
                    seq.remove(seq.size()-1);
                }
            }
        }
    }
}