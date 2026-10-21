class Solution {
    HashSet<String> set;
    int n;
    Boolean dp[];
    public boolean wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>(wordDict);
        this.n=s.length();
        dp=new Boolean[n];

        return solve(s,0);
    }

    private boolean solve(String s,int idx){
        if(idx==n) return true;

        if(dp[idx]!=null) return dp[idx];

        for(int i=idx;i<n;i++){

            if(set.contains(s.substring(idx,i+1))){
                if(solve(s,i+1)){
                    return dp[idx]=true;
                }
            }
        }
        return dp[idx]=false;
    }
}