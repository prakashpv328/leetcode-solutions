class Solution {
    public int[][] reconstructQueue(int[][] people) {
        ArrayList<int[]> list = new ArrayList<>();
        int n=people.length;
        Arrays.sort(people,(a,b)->{
            if(a[0]!=b[0])
                return b[0]-a[0];
            return a[1]-b[1];
        });
        for(int[] a:people){
            list.add(a[1],a);
        }
        return list.toArray(new int[0][]);
    }
}