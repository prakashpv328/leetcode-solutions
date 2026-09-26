class Solution {
    int n;
    int[] dp;
    public int longestSubsequence(int[] arr, int difference) {
        this.n=arr.length;
        // dp=new int[n];

        // int ans=1;

        // for(int i=0;i<n;i++){
        //     ans=Math.max(ans,solve(arr,i,difference));
        // }

        HashMap<Integer,Integer> map=new HashMap<>();
        int ans=0;

        for(int i=0;i<n;i++){
            int prev=arr[i]-difference;
            int len=map.getOrDefault(prev,0)+1;
            map.put(arr[i],len);
            ans=Math.max(ans,len);
        }
        return ans;
    }

    private int solve(int []arr,int curr,int diff){
        if(dp[curr]!=0) return dp[curr];
        int ans=1;
        for(int i=curr+1;i<n;i++){
            if(arr[i]-arr[curr]==diff)
            ans=Math.max(ans,1+solve(arr,i,diff));
        }
        return dp[curr]=ans;
    }
}