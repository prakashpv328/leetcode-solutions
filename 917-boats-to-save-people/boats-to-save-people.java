class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n=people.length;
        Arrays.sort(people);
        int ans=0;
        int l=0,r=n-1;
        while(l<=r){
            int sum=people[l]+people[r];
            if(sum<=limit){
                ans++;
                l++;
                r--;
            }
            else{
                ans++;
                r--;
            }
        }
        
        return ans;
    }
}