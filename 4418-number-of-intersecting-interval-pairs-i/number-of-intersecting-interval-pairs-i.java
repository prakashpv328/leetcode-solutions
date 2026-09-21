class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        int n=intervals.length;
        int []s=new int[n];
        int []e=new int[n];
        for(int i=0;i<n;i++){
            s[i]=intervals[i][0];
            e[i]=intervals[i][1];
        }
        Arrays.sort(s);
        Arrays.sort(e);
        int ans=0;
        int j=0;
        for(int i=0;i<n;i++){
            while(e[j]<s[i])j++;
            ans+=i-j;
        }
        return ans;
    }
}


