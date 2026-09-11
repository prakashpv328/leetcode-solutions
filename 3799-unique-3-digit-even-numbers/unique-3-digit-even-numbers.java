class Solution {
    int ans=0;
    public int totalNumbers(int[] digits) {
        int []arr=new int[10];
        for(int num:digits){
            arr[num]++;
        }
        count(0,0,arr);
        return ans;
    }

    public void count(int p,int num ,int[]arr){
        if(p==3){
            ans++;
            return;
        }

        for(int i=0;i<=9;i++){
        if(arr[i]==0) continue;

        if(p==0 && i==0) continue;

        if(p==2 && i%2!=0) continue;


        arr[i]--;
        count(p+1,num*10+i,arr);
        arr[i]++;
        
        }
    }
}