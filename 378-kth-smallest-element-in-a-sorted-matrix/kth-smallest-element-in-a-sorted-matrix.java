class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int m=matrix.length;
        int n=matrix[0].length;
        int l=m*n;
        k=l-k+1;
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                pq.offer(matrix[i][j]);
                if(pq.size()>k) pq.poll();
            }
        }


        return pq.peek();
    }
}