class Solution {
    public long minimumReplacement(int[] nums) {
        int l=nums.length;

        long r=nums[l-1];
        long ans=0;

        for(int i=l-2;i>=0;i--){
            long n=nums[i];
            if(n<=r){
                r=n;
            }
            else{
                long a=(n+r-1)/r;
                ans+=a-1;
                r=n/a;
            }
        }
        return ans;
    }
}