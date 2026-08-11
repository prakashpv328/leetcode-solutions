class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int l=triplets.length;
        int []res=new int[3];
        for(int []t:triplets){
            if(t[0]<=target[0] && t[1]<=target[1] && t[2]<=target[2]){
                res=new int[]{Math.max(res[0],t[0]),Math.max(res[1],t[1]),Math.max(res[2],t[2])};
            }
        }
        return Arrays.equals(res,target);
    }
}