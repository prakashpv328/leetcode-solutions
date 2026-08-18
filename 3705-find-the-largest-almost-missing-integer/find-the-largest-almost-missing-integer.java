class Solution {
    public int largestInteger(int[] nums, int k) {
        int l=nums.length;
        int ans=-1;

        for(int i=0;i<=50;i++){
            int count=0;
            for(int j=0;j<=l-k;j++){
                boolean found=false;
                for(int x=j;x<j+k;x++){
                    if(nums[x]==i){
                        found=true;
                        break;
                    }
                }
                if(found) count++;
            }
            if(count==1) ans=Math.max(ans,i);
        }
        return ans;

    }
}