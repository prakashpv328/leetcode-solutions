class Solution {
    public String maximumOddBinaryNumber(String s) {
        int l=s.length();
        int o=0;
        for(int i=0;i<l;i++){
            if(s.charAt(i)=='1'){
                o++;
            }
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<l-1;i++){
            if(o>1){
                sb.append('1');
                o--;
            }
            else{
                sb.append('0');
            }
        }
        sb.append('1');
        return sb.toString();
    }
}