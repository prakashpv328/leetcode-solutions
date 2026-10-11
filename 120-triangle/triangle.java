class Solution {
    int dp[][];
    int n;
    public int minimumTotal(List<List<Integer>> triangle) {
        this.n=triangle.size();
        dp=new int[n][n];

        int []prev=new int[n];
        

        for(int i=0;i<n;i++){
            prev[i]=triangle.get(n-1).get(i);
        }

        int right=0,left=0;

        for(int i=n-2;i>=0;i--){
            int []curr=new int[i+1];
            for(int j=i;j>=0;j--){
                right=prev[j+1];
                left=prev[j];
                curr[j]=triangle.get(i).get(j)+Math.min(right,left);
            }
            prev=curr;
        }
        return prev[0];
    }

    // private int solve(int r,int c,List<List<Integer>> list){
    //     if(r==n-1){
    //         return dp[r][c]=list.get(r).get(c);
    //     }

    //     if(dp[r][c]!=-1) return dp[r][c];

    //     int right=solve(r+1,c+1,list);
    //     int left=solve(r+1,c,list);

    //     return dp[r][c]=(list.get(r).get(c)+Math.min(right,left));
    // }
}