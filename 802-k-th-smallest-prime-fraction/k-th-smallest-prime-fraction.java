class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int l=arr.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->Double.compare(a.val,b.val));
        for(int i=1;i<l;i++){
            double val=(double)arr[0]/arr[i];
            pq.add(new Pair(0,i,val));
        }

        int count=0;
        while(k>1){
            Pair p=pq.poll();
            if(p.a+1<p.b){
                double d=(double)arr[p.a+1]/arr[p.b];
                pq.add(new Pair(p.a+1,p.b,d));
            }
            k--;
        }
        return new int[]{arr[pq.peek().a],arr[pq.peek().b]};
    }
}

class Pair{
    int a;
    int b;
    double val;
    Pair(int n1,int n2,double val){
        this.a=n1;
        this.b=n2;
        this.val=val;             
    }
}