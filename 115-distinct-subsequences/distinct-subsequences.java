class Solution {
    int dp[][];
    int m,n;
    public int numDistinct(String s, String t) {
        this.m=s.length();
        this.n=t.length();

        dp=new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(m-1,n-1,s,t);
    }

    private int solve(int i,int j,String s,String t){
        if(j<0) return 1;
        if(i<0) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int take=0,skip=0;
        
        if(s.charAt(i)==t.charAt(j)){
            take=solve(i-1,j-1,s,t)+solve(i-1,j,s,t);
        }
        else{
            skip=solve(i-1,j,s,t);
        }
        
        return dp[i][j]=take+skip;

    }
}