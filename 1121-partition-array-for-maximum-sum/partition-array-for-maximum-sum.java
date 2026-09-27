class Solution {
    int []dp;
    int n;
    public int maxSumAfterPartitioning(int[] arr, int k) {
        this.n=arr.length;
        dp=new int[n];
        Arrays.fill(dp,-1);
        return solve(0,arr,k);
    }

    private int solve(int i,int[] arr,int k){
        if(i>=n) return 0;
        if(dp[i]!=-1) return dp[i];
        int ans=0;
        int max=0;

        for(int j=i;j<Math.min(n,i+k);j++){
            max=Math.max(max,arr[j]);
            int len=j-i+1;
            int sum=max*len+solve(j+1,arr,k);
            ans=Math.max(ans,sum);
        }
        return dp[i]=ans; 
    }
}