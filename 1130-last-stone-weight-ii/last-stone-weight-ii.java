class Solution {
    int [][]dp;
    int n;
    public int lastStoneWeightII(int[] stones) {
        this.n=stones.length;
        int total=0;

        for(int x:stones){
            total+=x;
        }

        int half=total/2;

        dp=new int[n][half+1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }

        int best=solve(stones,0,half);

        return total-2*best;

    }

    private int solve(int []stones,int idx,int target){

        if(idx==n || target==0){
            return 0;
        }

        if(dp[idx][target]!=-1) return dp[idx][target];



        int skip=solve(stones,idx+1,target);
        int take=0;
        if(stones[idx]<=target){
            take=stones[idx]+solve(stones,idx+1,target-stones[idx]);
        }

        return dp[idx][target]=Math.max(skip,take);
    }
}