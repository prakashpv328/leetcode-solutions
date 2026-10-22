class Solution {
    public int distinctSubseqII(String s) {
        int MOD=1000000007;
        int tot=0;
        int dp[]=new int[26];
        int l=s.length();

        for(int i=0;i<l;i++){

            int c=s.charAt(i)-97;

            int add=(tot-dp[c]+MOD)%MOD;

            dp[c]=1+tot;

            tot=(dp[c]+add)%MOD;
        }

        return tot;
    }
}