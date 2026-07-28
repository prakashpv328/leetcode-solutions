class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> pq=new PriorityQueue<>(
            (a, b) -> b.getValue() - a.getValue()
        );
        int l=nums.length;
        for(int i=0;i<l;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        pq.addAll(map.entrySet());
        int []ans=new int[k];
        for(int i=0;i<k;i++){
            ans[i]=pq.poll().getKey();
        }
        return ans;
    }
}