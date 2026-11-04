class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int s=0,c=0,l=nums.length;
        map.put(0,1);

        for(int i=0;i<l;i++){
            s+=nums[i];
           
            if(map.get(s-k)!=null){
                c=c+map.get(s-k);
            }

            map.put(s,map.getOrDefault(s,0)+1);
            
        }

        return c;

    }
}