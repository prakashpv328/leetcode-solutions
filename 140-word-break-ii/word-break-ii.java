class Solution {
    HashSet<String> set;
    List<String> dp[];
    int n;
    public List<String> wordBreak(String s, List<String> wordDict) {
        set=new HashSet<>(wordDict);
        dp=new ArrayList[s.length()];
        n=s.length();

        return solve(s,0);
    }

    private List<String> solve(String s,int idx){
        ArrayList<String> ans=new ArrayList<>();
        if(idx==n){
            ans.add("");
            return ans;
        }

        if(dp[idx]!=null) return dp[idx];

        for(int i=idx;i<n;i++){
            String str=s.substring(idx,i+1);

            if(set.contains(str)){
                List<String> list=solve(s,i+1);

                for(String st:list){
                    if(st.equals("")){
                        ans.add(str);
                    }
                    else{
                        ans.add(str+" "+st);
                    }
                }
            }
        }
        return dp[idx]=ans;
    }
}