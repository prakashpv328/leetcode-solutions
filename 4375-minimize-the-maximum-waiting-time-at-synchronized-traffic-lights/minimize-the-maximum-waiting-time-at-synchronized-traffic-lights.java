class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int l=lights.length;
        int a=arrivalTime.length;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<l;i++){
            max=Math.max(max,lights[i]);
        }

        int m=0;
        for(int arr:arrivalTime){
            int rem=arr%period;
            if(rem>=max){
                int sub=period-rem;
                m=Math.max(sub,m);
            }
        }
        return m;
    }
}