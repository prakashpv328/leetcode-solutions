class Solution {
    public int minAddToMakeValid(String str) {

        // int l=s.length(),c=0;
        // Stack<Character> stack=new Stack();
        // for(int i=0;i<l;i++){
        //     if(s.charAt(i)=='('){
        //         stack.push('(');
        //     }
        //     else{
        //         if(!stack.isEmpty())
        //         stack.pop();
        //         else{
        //             c++;
        //         }
        //     }
        // }
        // return c+stack.size();



        int l = str.length(), c = 0, s = 0;
        for (int i = 0; i < l; i++) {
            if (str.charAt(i) == '(')
                s++;
            else

            if (s > 0)
                s--;
            else
                c++;

        }
        return c + s;
    }
}