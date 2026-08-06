class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int l=profits.length;
        int [][]arr=new int[l][2];
        for(int i=0;i<l;i++){
            arr[i][0]=capital[i];
            arr[i][1]=profits[i];
        }

        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));

        int i=0;

        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->b-a);

        while(k>0){
            while(i<l && arr[i][0]<=w){
                pq.offer(arr[i][1]);
                i++;
            }
            if(pq.isEmpty()){
                break;
            }
            w+=pq.poll();
            k--;
        }
        return w;

    }

}