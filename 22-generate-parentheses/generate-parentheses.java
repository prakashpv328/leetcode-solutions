class Solution {
    List<String> ans=new ArrayList<>();
    StringBuilder sb=new StringBuilder();
    public List<String> generateParenthesis(int n) {
        func(n,0,0,0);
        // System.out.print(ans.size());
        return ans;
    }

    void func(int n,int o,int c,int t){
            if(t==n*2){
                ans.add(sb.toString());
                return;
            }
        if(o<n){
            sb.append('(');
            func(n,o+1,c,t+1);
            sb.deleteCharAt(sb.length()-1);
        }
        if(o>c){
            sb.append(')');
            func(n,o,c+1,t+1);
            sb.deleteCharAt(sb.length()-1);
        }
       
    }

}