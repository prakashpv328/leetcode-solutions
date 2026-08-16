class Solution {
    public int minimumCost(int m, int n, int[] hCut, int[] vCut) {
        int hl=hCut.length;
        int vl=vCut.length;
        Arrays.sort(vCut);
        Arrays.sort(hCut);
        int i=vl-1,j=hl-1;
        int nv=1,nh=1;
        int ans=0;
        while(i>=0 && j>=0){
            if(vCut[i]>hCut[j]){
                ans+=vCut[i--]*nh;
                nv++;
            }
            else{
                ans+=hCut[j--]*nv;
                nh++;
            }
        }
        while(i>=0){
            ans+=vCut[i--]*nh;
            nv++;
        }
        while(j>=0){
            ans+=hCut[j--]*nv;
            nh++;
        }
        return ans;
    }
}