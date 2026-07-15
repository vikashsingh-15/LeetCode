class Solution {
    public int gcdOfOddEvenSums(int n) {
        return gcd(n * n, n * (n + 1));
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}