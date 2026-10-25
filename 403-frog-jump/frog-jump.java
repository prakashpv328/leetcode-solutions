class Solution {
    Boolean [][]dp;
    HashMap<Integer,Integer> map=new HashMap<>();
    int l;
    public boolean canCross(int[] stones) {
        this.l=stones.length;
        dp=new Boolean[l][l];

        for(int i=0;i<l;i++){
            map.put(stones[i],i);
        }

        return solve(0,0,stones);
    }

    private boolean solve(int idx,int k,int []stones){
        if(idx==l-1) return true;

        if(dp[idx][k]!=null) return dp[idx][k];

        for(int i=k-1;i<=k+1;i++){

            if(i<=0) continue;

            int nextPos=stones[idx]+i;

            if(map.containsKey(nextPos)){
                int nextIndex=map.get(nextPos);

                if(solve(nextIndex,i,stones)){
                    return dp[idx][k]=true;
                }
            }
        }

        return dp[idx][k]=false;
    }
}