class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int l=mat.length;
        int []curr=mat[0];
        for(int i=1;i<l;i++){
            curr=merge(curr,mat[i],k);
        }
        return curr[k-1];
    }

    int[] merge(int[] curr,int []mat,int k){
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));

        for(int i=0;i<curr.length;i++){
            pq.offer(new int[]{curr[i]+mat[0],i,0});
        }

        int size=Math.min(k,curr.length*mat.length);
        int [] result=new int[size];
        int idx=0;

        while(idx<size){
            int []p=pq.poll();
            int sum=p[0];
            int i=p[1];
            int j=p[2];

            result[idx++]=sum;

            if(j+1<mat.length){
                pq.offer(new int[]{curr[i]+mat[j+1],i,j+1});
            }
        }
        return result;
    }
}