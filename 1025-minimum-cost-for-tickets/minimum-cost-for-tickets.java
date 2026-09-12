class Solution {
    int dp[];
    public int mincostTickets(int[] days, int[] costs) {
        dp=new int[days.length];
        Arrays.fill(dp,-1);
       return solve(0,days,costs);
    }
    private int solve(int i,int []days,int []costs){
        if(i>=days.length){
            return 0;
        }
        if(dp[i]!=-1) return dp[i];
        int one=costs[0]+solve(i+1,days,costs);

        int next7=upperBound(days,days[i]+7);
        int seven=costs[1]+solve(next7,days,costs);

        int next30=upperBound(days,days[i]+30);
        int thirty=costs[2]+solve(next30,days,costs);

        return dp[i]=Math.min(one,Math.min(seven,thirty));
    }

    private int upperBound(int []days,int target){
        int l=0;
        int r=days.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if(days[mid]>=target){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }
}