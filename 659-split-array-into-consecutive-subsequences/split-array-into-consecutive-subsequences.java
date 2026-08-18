class Solution {
    public boolean isPossible(int[] nums) {
        int l=nums.length;
        HashMap<Integer,Integer> count=new HashMap<>();
        HashMap<Integer,Integer> end=new HashMap<>();

        for(int i:nums){
            count.put(i,count.getOrDefault(i,0)+1);
        }

        for(int x:nums){
            if(count.get(x)==0) continue;

            count.put(x,count.getOrDefault(x,0)-1);

            if(end.getOrDefault(x-1,0)>0){
                end.put(x-1,end.getOrDefault(x-1,0)-1);
                end.put(x,end.getOrDefault(x,0)+1);
            }
            else{
                if(count.getOrDefault(x+1,0)<=0 || count.getOrDefault(x+2,0)<=0){
                    return false;
                }

                count.put(x+1,count.getOrDefault(x+1,0)-1);
                count.put(x+2,count.getOrDefault(x+2,0)-1);

                end.put(x+2,end.getOrDefault(x+2,0)+1);
            }
        }
        return true;
    }
}