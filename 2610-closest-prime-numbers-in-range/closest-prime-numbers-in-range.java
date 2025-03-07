class Solution {
    public int[] closestPrimes(int left, int right) {
        int prevPrime = -1, minDiff = Integer.MAX_VALUE;
        int num1 = -1, num2 = -1;

        for (int i = left; i <= right; i++) {
            if (isPrime(i)) {  
                if (prevPrime != -1) { 
                    int diff = i - prevPrime;
                    if (diff < minDiff) { 
                        minDiff = diff;
                        num1 = prevPrime;
                        num2 = i;
                    }
                }
                prevPrime = i;
            }
        }

        return (num1 == -1) ? new int[]{-1, -1} : new int[]{num1, num2}; 
    }
    public  boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true; 
        if (n % 2 == 0 || n % 3 == 0) return false; 
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}