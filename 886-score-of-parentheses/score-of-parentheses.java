class Solution {
    public int scoreOfParentheses(String s) {
        int l=s.length(),ans=0,c=0;
        Stack<Character> stack=new Stack<>();
        for(int i=0;i<l;i++){
            if(s.charAt(i)=='('){
                stack.push('(');
                c=1;
            }
            else{
                if(c==1)
                ans+=Math.pow(2,stack.size()-1);
                stack.pop();
                c=0;
            }
        }
        return ans;
    }
}