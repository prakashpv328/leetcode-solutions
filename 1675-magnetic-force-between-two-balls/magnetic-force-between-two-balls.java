class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length;
        int l=0;
        int r=position[n-1];
        int ans=0;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(solve(position,mid,m)){
                ans=mid;
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return ans;
    }

    private boolean solve(int []arr,int mid,int m){
        int c=1;
        int prev=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-prev>=mid){
                c++;
                prev=arr[i];
            }
        }
            if(c>=m){
                return true;
            }
        return false;
    }
}