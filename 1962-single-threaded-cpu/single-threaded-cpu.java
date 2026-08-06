class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        Task[] arr=new Task[n];
        for(int i=0;i<n;i++){
            arr[i]=new Task(i,tasks[i][0],tasks[i][1]);
        }
        Arrays.sort(arr,(a,b)->a.et-b.et);

        PriorityQueue<Task> pq=new PriorityQueue<>((a,b)->{
            if(a.pt==b.pt){
                return Integer.compare(a.idx,b.idx);
            }
            return Integer.compare(a.pt,b.pt);
        });


        int[] ans = new int[n];
        int ansIdx = 0;
        int taskIdx = 0;
        int curTime= 0;

        while(ansIdx < n){
            while(taskIdx < n && arr[taskIdx].et <= curTime){
                pq.offer(arr[taskIdx++]);
            }
            if(pq.isEmpty()){
                curTime = arr[taskIdx].et;
            }else{
                curTime += pq.peek().pt;
                ans[ansIdx++] = pq.poll().idx;
            }
        }
        return ans;
    }  
}

class Task{
    int idx;
    int et;
    int pt;
    Task(int idx,int et,int pt){
        this.idx=idx;
        this.et=et;
        this.pt=pt;
    }
}