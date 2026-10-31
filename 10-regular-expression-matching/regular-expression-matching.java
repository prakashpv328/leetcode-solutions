class Solution {
    Boolean dp[][];
    int m,n;
    public boolean isMatch(String s, String p) {
        this.m=s.length();
        this.n=p.length();

        dp=new Boolean[m+1][n+1];

        return solve(0,0,s,p);
    }

    private boolean solve(int i,int j,String s,String p){

        if(i==m && j==n) return true;
        if(j==n) return false;

        if(dp[i][j]!=null) return dp[i][j];

        boolean match=i<m && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');

        boolean ans;

        if(j+1<n && p.charAt(j+1)=='*'){
            ans=(solve(i,j+2,s,p)) || (match && solve(i+1,j,s,p));
        }
        else{
            ans=(match && solve(i+1,j+1,s,p));
        }

        return dp[i][j]=ans;
    }
}