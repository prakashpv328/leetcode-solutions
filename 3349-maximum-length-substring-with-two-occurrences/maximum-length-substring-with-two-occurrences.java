class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int []map=new int[26];
        int l=0;
        int ans=0;
        for(int r=0;r<n;r++){
            char c=s.charAt(r);
            while(map[c-'a']>1){
                char ch=s.charAt(l);
                map[ch-'a']--;
                l++;
            }
            map[c-'a']++;
            ans=Math.max(ans,r-l+1);
        }

        return ans;
    }
}