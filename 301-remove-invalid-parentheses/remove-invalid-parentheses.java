class Solution {
    HashSet<String> ans=new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int left=0,right=0,n=s.length();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                left++;
            }
            else if(ch==')'){
                if(left>0){
                    left--;
                }
                else{
                    right++;
                }
            }
        }
        solve(s,0,left,right,0,"");

        return new ArrayList<>(ans);
    }

    private void solve(String str,int idx,int left,int right,int bal,String curr){
        if(bal<0) return;

        if(idx==str.length()){
            if(left==0 && right==0 && bal==0){
                ans.add(curr);
            }
            return;
        }

        char ch=str.charAt(idx);

        if(ch!='(' && ch!=')'){
            solve(str,idx+1,left,right,bal,curr+ch);
            return;
        }

        if(ch=='(' && left>0){
            solve(str,idx+1,left-1,right,bal,curr);
        }

        if(ch==')' && right>0){
            solve(str,idx+1,left,right-1,bal,curr);
        }

        if(ch=='('){
            solve(str,idx+1,left,right,bal+1,curr+ch);
        }
        else{
            solve(str,idx+1,left,right,bal-1,curr+ch);
        }
        return;
    }
}