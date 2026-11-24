class Solution {
    public int maxLength(int[] nums) {
        int l=nums.length;
        int ans=0;

        for(int i=0;i<l;i++){
            int pro=1;
            int gcd=nums[i];
            int lcm=nums[i];
            for(int j=i;j<l;j++){
                pro*=nums[j];
                gcd=gcd(gcd,nums[j]);
                lcm=nums[j]*lcm/gcd(lcm,nums[j]);
                if(pro==lcm*gcd) ans=Math.max(ans,j-i+1);
            }
        }

        return ans;
    }

    private int gcd(int a,int b){
        while(b!=0){
            int t=b;
            b=a%b;
            a=t;
        }
        return a;
    }
}