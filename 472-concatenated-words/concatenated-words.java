class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        HashSet<String> set=new HashSet<>(Arrays.asList(words));
        List<String> ans=new ArrayList<>();

        for(String word:words){
            set.remove(word);

            int dp[]=new int[word.length()];
            Arrays.fill(dp,-1);

            if(solve(word,0,set,dp)){
                ans.add(word);
            }

            set.add(word);
        }
        return ans;
    }

    private boolean solve(String str,int idx,HashSet<String> set,int[] dp){
        if(idx==str.length()) return true;

        if(dp[idx]!=-1) return dp[idx]==1;

        for(int i=idx;i<str.length();i++){
            String s=str.substring(idx,i+1);

            if(set.contains(s) && solve(str,i+1,set,dp)){
                dp[idx]=1;
                return true;
            }
        }
        dp[idx]=0;
        return false;

    }
}