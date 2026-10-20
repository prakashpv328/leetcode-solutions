class Solution {
    public int longestStrChain(String[] words) {
        int n=words.length;

        Arrays.sort(words,(a,b)->a.length()-b.length());

        int dp[]=new int[n];
        Arrays.fill(dp,1);

        int ans=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(check(words[i],words[j]) && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                }
            }
            ans=Math.max(ans,dp[i]);
        }
        return ans;
    }

    private boolean check(String s1,String s2){
        if(s1.length()!=s2.length()+1) return false;

        int l1=0,l2=0;

        while(l1<s1.length()){
            if(l2<s2.length() && s1.charAt(l1)==s2.charAt(l2)){
                l1++;
                l2++;
            }
            else{
                l1++;
            }
        }
        return l1==s1.length() && l2==s2.length();
    }
}