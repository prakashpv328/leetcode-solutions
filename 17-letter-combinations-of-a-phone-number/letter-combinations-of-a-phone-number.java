class Solution {
    List<String> list=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    Map<Integer,String> map=new HashMap<>(
            Map.of(2,"abc",
                    3,"def",
                    4,"ghi",
                    5,"jkl",
                    6,"mno",
                    7,"pqrs",
                    8,"tuv",
                    9,"wxyz"
                )
        );
        
    public List<String> letterCombinations(String str) {  
        func(str,0);
        return list;
    }

    void func(String str,int c){
        if(c==str.length()){
            list.add(sb.toString());
            return;
        }
        int num=str.charAt(c)-'0';
        for(int i=0;i<map.get(num).length();i++){
            sb.append(map.get(num).charAt(i));
            func(str,c+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}