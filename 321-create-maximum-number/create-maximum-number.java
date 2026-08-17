class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m=nums1.length;
        int n=nums2.length;
        int []ans=new int[k];

        int start=Math.max(0,k-n);
        int end=Math.min(k,m);


        for(int i=start;i<=end;i++){
            int []arr1=maxSequence(nums1,i);
            int []arr2=maxSequence(nums2,k-i);

            int[] candidate=merge(arr1,arr2);

            if(greater(candidate,0,ans,0)){
                ans=candidate;
            }

        }
        return ans;
    }

    int[] maxSequence(int []nums,int k){
        int n=nums.length;
        int remove=n-k;

        int []stack=new int[k];
        int top=0;

        for(int i=0;i<n;i++){
            while(top>0 && stack[top-1]<nums[i] && remove>0){
                top--;
                remove--;
            }
            if(top<k){
                stack[top++]=nums[i];
            }
            else{
                remove--;
            }
        }
        return stack;
    }

    int[] merge(int []a,int []b){
        int l1=a.length,l2=b.length;
        int []result=new int[l1+l2];

        int i=0,j=0,p=0;

        while(i<a.length || j<b.length){
            if(greater(a,i,b,j)){
                result[p++]=a[i++];
            }
            else{
                result[p++]=b[j++];
            }
        }
        return result;
    }

    boolean greater(int a[],int i,int b[],int j){
        while(i<a.length && j<b.length){
            if(a[i]>b[j]){
                return true;
            }
            if(a[i]<b[j]){
                return false;
            }
            i++;
            j++;
        }

        return i!=a.length;
    }
}