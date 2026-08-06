class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int l=wage.length;
        double [][]arr=new double[l][2];
        for(int i=0;i<l;i++){
            arr[i][0]=(double)wage[i]/quality[i];
            arr[i][1]=quality[i];
        }
        Arrays.sort(arr,(a, b) -> Double.compare(a[0], b[0]));
        PriorityQueue<Double> pq=new PriorityQueue<>((a,b)->Double.compare(b,a));
        double ans=Double.MAX_VALUE;
        int res=0;

        for(int i=0;i<l;i++){
            pq.offer(arr[i][1]);
            res+=arr[i][1];

            if(pq.size()>k){
                res-=pq.poll();
            }

            if(pq.size()==k){
                ans=Math.min(ans,res*arr[i][0]);
            }
        }
        return ans;
    }
}