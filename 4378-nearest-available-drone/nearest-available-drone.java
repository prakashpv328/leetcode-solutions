class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int l=drones.length;
        int ans=Integer.MAX_VALUE;
        int id=-1;
        for(int i=0;i<l;i++){
            int x=Math.abs(target[0]-drones[i][0]);
            int y=Math.abs(target[1]-drones[i][1]);
            if(ans>x+y && x+y<=drones[i][2]){
                id=i;
                ans=x+y;
            }
        }
        return id;
    }
}