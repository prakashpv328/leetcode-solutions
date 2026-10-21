class Solution {
    HashSet<String> set;
    int n;
    Boolean dp[];
    public boolean wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>(wordDict);
        this.n=s.length();
        // dp=new Boolean[n+1]; this is only for memo beacause to see bot true and false we not visited as null

        boolean dp[]=new boolean[n+1];
        dp[n]=true;

        for(int i=n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                String str=s.substring(i,j+1);

                if(set.contains(str) && dp[j+1]){
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[0];
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