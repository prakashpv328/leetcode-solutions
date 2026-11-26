class Solution {
    public boolean canAliceWin(int n) {
        int st=10;
        boolean ans=false;
        while(n>=st){
            n-=st;
            ans=!ans;
            st--;
        }
        return ans;
    }
}