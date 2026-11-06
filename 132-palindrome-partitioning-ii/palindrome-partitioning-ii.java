class Solution {
    int dp[];
    int l;
    public int minCut(String s) {
        this.l=s.length();
        if(l<=1) return 0;

        dp=new int[l+1];
        dp[l]=-1;

        for(int i=l-1;i>=0;i--){
            int ans=Integer.MAX_VALUE;
            for(int j=i;j<l;j++){
                if(isPalindrome(i,j,s)){
                    int cost=1+dp[j+1];
                    ans=Math.min(ans,cost);
                }
            }
            dp[i]=ans;
        }

        return dp[0];
    }

    private int solve(int i,String s){
        if(i==l) return 0;

        if(dp[i]!=-1) return dp[i];

        int ans=Integer.MAX_VALUE;

        for(int j=i;j<l;j++){
            if(isPalindrome(i,j,s)){
                int cost=1+solve(j+1,s);
                ans=Math.min(ans,cost);
            }
        }

        return dp[i]=ans;
    }

    private boolean isPalindrome(int i,int j,String str){
        while(i<=j){
            if(str.charAt(i++)!=str.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}