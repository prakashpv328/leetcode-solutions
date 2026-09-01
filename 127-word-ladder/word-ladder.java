class Solution {
    public int ladderLength(String begin, String end, List<String> words) {
        Set<String> set=new HashSet<>();
        Queue<Pair> queue=new LinkedList<>();
        queue.offer(new Pair(begin,1));
        int len=words.size();
        for(int i=0;i<len;i++){
            set.add(words.get(i));
        }
        set.remove(begin);

        while(!queue.isEmpty()){
            Pair p=queue.poll();
            String str=p.st;
            int step=p.n;
            if(str.equals(end)) return step;

            for(int i=0;i<str.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] chars=str.toCharArray();
                    chars[i]=ch;
                    String newStr=String.valueOf(chars);

                    if(set.contains(newStr)){
                        set.remove(newStr);
                        queue.offer(new Pair(newStr,step+1));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    String st;
    int n;
    Pair(String _st,int _n){
        st=_st;
        n=_n;
    }
}