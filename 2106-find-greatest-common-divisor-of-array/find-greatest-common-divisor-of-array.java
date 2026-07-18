class Solution {

    public int findGCD(int[] nums) {
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        for (int num : nums) {
            mn = Math.min(mn, num);
            mx = Math.max(mx, num);
        }
        return gcd(mx, mn);
    }

    private int gcd(int a, int b) {

        if(b==0){
            return a;
        }
        return gcd(b,a%b);

    }
}