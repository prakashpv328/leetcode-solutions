class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans=0,l=intervals.length;
        Arrays.sort(intervals,(a,b)->a[1]-b[1]);
        int prev=intervals[0][1];
        for(int i=1;i<l;i++){
            if(prev>intervals[i][0]){
                ans++;
            }
            else{
                prev=intervals[i][1];
            }
        }
        return ans;
    }
}