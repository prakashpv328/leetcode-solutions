class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long total = 0;
        int max=0;
        for (int p : piles){
            max=Math.max(p,max);
            total += p;
        }

        int l = (int) ((total - 1) / h) + 1;
        int r = (int)max;

        int ans = r;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (solve(piles,mid,h)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }

    private boolean solve(int []piles,int mid,int h){
        long s=0;
        for (int p : piles) {
            s += p / mid;
            s += p % mid > 0 ? 1 : 0;
            if (s > h)
                break;
        }
        return s<=h;
    }
}
