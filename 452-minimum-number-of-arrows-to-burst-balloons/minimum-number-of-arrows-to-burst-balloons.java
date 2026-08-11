class Solution {
    public int findMinArrowShots(int[][] points) {
        // 1,6 2,8 7,12 10,16

        int ans=0;
        int l=points.length;
        // if(l==0) return 0;
        Arrays.sort(points,(a,b)->Integer.compare(a[1],b[1]));
        int prev=points[0][1];
        for(int i=1;i<l;i++){
            if(prev<points[i][0]){
                ans++;
                prev=points[i][1];
            }
        }
        return ans+1;
    }
}