class Solution {
    public int reverse(int n) {
         int rev = 0;
        while (n != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            int digit = n % 10;
            n /= 10;
            rev = rev * 10 + digit;
        }
        return rev;
    }
}