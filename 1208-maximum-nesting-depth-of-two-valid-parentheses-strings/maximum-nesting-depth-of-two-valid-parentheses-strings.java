class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int ans[]=new int[seq.length()];
        int i=0,dep=0;
        for(char ch:seq.toCharArray()){
            if(ch=='('){
                ans[i++]=dep%2;
                dep++;
            }
            else{
                dep--;
                ans[i++]=dep%2;
            }
        }
        return ans;
    }
}