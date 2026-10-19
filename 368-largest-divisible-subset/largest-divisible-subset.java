class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int l=nums.length;
        int dp[]=new int[l];
        int ans=0;

        List<Integer> list=new ArrayList<>();

        int hash[]=new int[l];
        int last=0;

        for(int i=0;i<l;i++){
            hash[i]=i;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0 && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    hash[i]=j;
                }
            }
            if(ans<dp[i]){
                ans=dp[i];
                last=i;
            }
        }

        list.add(nums[last]);
        while(hash[last]!=last){
            last=hash[last];
            list.add(nums[last]);
        }
        return list;
    }
}