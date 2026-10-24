class Solution {
    public int numOfWays(int n) {
        int MOD=1000000007;

        long a=6;
        long b=6;

        for(int i=2;i<=n;i++){
            long na=(3*a+b*2)%MOD;
            long nb=(2*a+b*2)%MOD;

            a=na;
            b=nb;
        }

        return (int)((a+b)%MOD);
    }
}