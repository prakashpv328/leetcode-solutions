class Solution {
    int dp[][][];
    int count[][];
    public int findMaxForm(String[] strs, int m, int n) {
        int l=strs.length;

        dp=new int[l][m+1][n+1];

        count=new int[l][2];

        for(int i=0;i<l;i++){
            for(char ch:strs[i].toCharArray()){
                if(ch=='0') count[i][0]++;
                else count[i][1]++;
            }
        }

        for(int i=0;i<l;i++){
            for(int j=0;j<=m;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(strs,m,n,l-1);
    }

    private int solve(String[] strs,int m,int n,int idx){
        if(idx==0){
            if(m>=count[idx][0] && n>=count[idx][1]) return 1;
            else return 0;
        }

        if(dp[idx][m][n]!=-1) return dp[idx][m][n];

        int skip=solve(strs,m,n,idx-1);
        int take=0;

        if(m>=count[idx][0] && n>=count[idx][1]){
            take=1+solve(strs,m-count[idx][0],n-count[idx][1],idx-1);
        }
        return dp[idx][m][n]=Math.max(skip,take);
    }
}