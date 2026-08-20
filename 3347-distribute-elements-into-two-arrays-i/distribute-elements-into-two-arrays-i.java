class Solution {
    public int[] resultArray(int[] nums) {
        int l=nums.length;
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        l1.add(nums[0]);
        l2.add(nums[1]);
        for(int i=2;i<l;i++){
            if(l1.get(l1.size()-1)>l2.get(l2.size()-1)){
                l1.add(nums[i]);
            }
            else{
                l2.add(nums[i]);
            }
        }
        int n1=l1.size(),n2=l2.size();

        // System.out.print(l1+" "+l2);
        for(int i=0;i<n1;i++){
            nums[i]=l1.get(i);
        }
        for(int i=n1;i<l;i++){
            nums[i]=l2.get(i-n1);
        }
        return nums;
    }
}