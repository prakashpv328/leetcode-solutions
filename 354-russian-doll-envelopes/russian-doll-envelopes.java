class Solution {
    public int maxEnvelopes(int[][] nums) {
        int n=nums.length;

        Arrays.sort(nums,(a,b)->{
            if(a[0]==b[0]){
                return Integer.compare(b[1],a[1]);
            }
            return Integer.compare(a[0],b[0]);
        });

        int temp[]=new int[n];
        int len=0;
        int ans=0;

        for(int i=0;i<n;i++){
            int num=nums[i][1];
            int idx=lowerBound(0,len,temp,num);

            temp[idx]=num;
            if(idx==len){
                len++;
            }
        }
        return len;
    }

    private int lowerBound(int l,int r,int[] temp,int tar){
        while(l<r){
            int mid=l+(r-l)/2;
            if(temp[mid]<tar){
                l=mid+1;
            }
            else{
                r=mid;
            }
        }
        return l;
    }
}