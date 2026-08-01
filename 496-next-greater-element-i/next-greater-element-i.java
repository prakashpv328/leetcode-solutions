class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack=new Stack<>();
        Map<Integer,Integer> map=new HashMap<>();
        int l1=nums1.length,l2=nums2.length;

        for(int i=l2-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek()<nums2[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                map.put(nums2[i],stack.peek());
            }
            else{
                map.put(nums2[i],-1);
            }
            stack.push(nums2[i]);
        }

        for(int i=0;i<l1;i++){
            nums1[i]=map.get(nums1[i]);
        }
        return nums1;
    }
}