class Solution {
    public boolean checkValidString(String s) {
        int min=0,max=0;
        for(char c:s.toCharArray()){
            if(c=='('){
                min=min+1;
                max=max+1;
            }
            else if(c==')'){
                min=min-1;
                max=max-1;
            }
            else{
                min=min-1;
                max=max+1;
            }
            if(min<0) min=0;
            if(max<0) return false;
        }

        return min==0;
    }
}