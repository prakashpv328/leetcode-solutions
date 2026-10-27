class Solution {
    int dp[][];
    public int minCost(int n, int[] cuts) {
        int l=cuts.length;

        int nums[]=new int[l+2];
        nums[0]=0;
        nums[l+1]=n;

        for(int i=1;i<=l;i++){
            nums[i]=cuts[i-1];
        }
        Arrays.sort(nums);

        dp=new int[l+2][l+2];


        for(int i=0;i<=l+1;i++){
            Arrays.fill(dp[i],-1);
        }

        return solve(1,l,nums);
    }

    private int solve(int i,int j,int[] nums){
        if(i>j) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int ans=Integer.MAX_VALUE;


        for(int k=i;k<=j;k++){
            int cost=nums[j+1]-nums[i-1]+solve(i,k-1,nums)+solve(k+1,j,nums);
            ans=Math.min(ans,cost);
        }

        return dp[i][j]=ans;
    }
}