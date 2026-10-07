class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;

        int ones=0;

        for(int i=0;i<n;i++){
            ones+=nums[i];
        }
        
        int []arr=new int[n+n];
        for(int i=0;i<n+n;i++){
            arr[i]=nums[i%n];
        }

        int l=0;
        int ans=Integer.MAX_VALUE;
        int curr=0;

        for(int r=0;r<arr.length;r++){
            curr+=arr[r];
            if(r>=ones-1){
                int z=ones-curr;
                ans=Math.min(z,ans);
                curr-=arr[l++];
            }

        }
        return ans;
    }
}

// 0 1 0 1 1 0 0 