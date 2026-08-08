class Solution {
    public int jump(int[] nums) {
        int n=0,f=0,ans=0;
        int l=nums.length;

        while(f<l-1){
            int farthest=0;
            for(int i=n;i<=f;i++){
                farthest=Math.max(farthest,i+nums[i]);
            }
            n=f+1;
            f=farthest;
            ans++;
        }
        return ans;
    }
}