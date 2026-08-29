class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l=arr.length;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<k;i++){
            list.add(arr[i]);
        }
        for(int i=k;i<l;i++){
            if(Math.abs(arr[i-k]-x)>Math.abs(arr[i]-x)){
                list.remove(Integer.valueOf(arr[i-k]));
                list.add(arr[i]);
            }
        }
        return list;
    }
}