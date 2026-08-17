class Solution {
    public long makeSimilar(int[] nums, int[] target) {
        List<Integer> ol=new ArrayList<>();
        List<Integer> el=new ArrayList<>();
        List<Integer> ot=new ArrayList<>();
        List<Integer> et=new ArrayList<>();

        for(int x:nums){
            if(x%2==0){
                el.add(x);
            }
            else{
                ol.add(x);
            }
        }

        for(int x:target){
            if(x%2==0){
                et.add(x);
            }
            else{
                ot.add(x);
            }
        }

        Collections.sort(ol);
        Collections.sort(el);
        Collections.sort(ot);
        Collections.sort(et);

        long ans=0;

        for(int i=0;i<ol.size();i++){
            if(ol.get(i)<ot.get(i)){
                ans+=ot.get(i)-ol.get(i);
            }
        }

        for(int i=0;i<el.size();i++){
            if(el.get(i)<et.get(i)){
                ans+=et.get(i)-el.get(i);
            }
        } 

        // for(int i=0;i<l;i++){
        //     if(nums[i]<target[i]){
        //         ans+=target[i]-nums[i];
        //     }
        // }
        return ans/2;
    }
}