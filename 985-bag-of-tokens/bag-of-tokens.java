class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n=tokens.length;
        int ans=0,s=0;
        int l=0,r=n-1;
        while(l<=r){
            if(power>=tokens[l]){
                power-=tokens[l];
                s++;
                l++;
                ans=Math.max(ans,s);
            }
            else if(s>0){
                power+=tokens[r];
                s--;
                r--;
            }
            else{
                return ans;
            }
        }
        return ans;
    }
}