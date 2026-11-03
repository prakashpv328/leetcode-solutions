class Solution {
    int dp[][];
    public int mctFromLeafValues(int[] arr) {
        int l=arr.length;

        dp=new int[l+1][l+1];

        for(int i=0;i<=l;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(0,l-1,arr);
    }

    private int solve(int i,int j,int []arr){
        if(i==j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int maxL=0,maxR=0,ans=Integer.MAX_VALUE;

        for(int k=i;k<j;k++){

            int left=solve(i,k,arr);
            int right=solve(k+1,j,arr);

            maxL=Math.max(maxL,arr[k]);
            
            for(int x=k+1;x<=j;x++){
                maxR=Math.max(maxR,arr[x]);
            }

            int cost=left+right+maxL*maxR;
            ans=Math.min(ans,cost);
        }

        return dp[i][j]=ans;
    }
}