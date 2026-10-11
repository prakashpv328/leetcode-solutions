class Solution {
    int dp[][];
    int n;
    public int bestTeamScore(int[] scores, int[] ages) {
        this.n=scores.length;

        dp=new int[n][n+1];
        
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);

        int [][]players=new int[n][2];

        for(int i=0;i<n;i++){
            players[i][0]=ages[i];
            players[i][1]=scores[i];
        }

        Arrays.sort(players,(a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });

        for(int i=0;i<n;i++){
            scores[i]=players[i][1];
        }

        return solve(0,-1,scores);
    }

    private int solve(int idx,int prev,int []scores){
        if(idx==n){
            return 0;
        }

        if(dp[idx][prev+1]!=-1) return dp[idx][prev+1];

        int skip=solve(idx+1,prev,scores);

        int take=0;

        if(prev==-1 || scores[idx]>=scores[prev]){
            take=scores[idx]+solve(idx+1,idx,scores);
        }

        return dp[idx][prev+1]=Math.max(skip,take);
    }
}