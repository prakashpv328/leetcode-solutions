class Solution {
    public boolean parseBoolExpr(String expression) {
        Stack<Character> st=new Stack<>();
        int l=expression.length();

        for(int i=0;i<l;i++){
            char c=expression.charAt(i);
            if(c=='(' || c==',') continue;
            else if(c=='&' || c=='|' || c=='t' || c=='f' || c=='!'){
                st.push(c);
            }
            else{
                boolean t=false,f=false;

                while(st.peek()!='!' && st.peek()!='&' && st.peek()!='|'){
                    char top=st.pop();
                    if(top=='t') t=true;
                    if(top=='f') f=true;
                }

                char op=st.pop();
                if(op=='&'){
                    st.push(f?'f':'t');
                }
                else if(op=='|'){
                    st.push(t?'t':'f');
                }
                else{
                    st.push(t?'f':'t');
                }
            }
        }
        return st.peek()=='t';
    }
}