class Solution {

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1.0;
        }

        if (n < 0) {
            return 1.0 / (x * myPow(x, -(n + 1)));
        }

        if (n % 2 == 0) {
            return myPow (x * x, n / 2);
        } else {
            return x * myPow (x, n - 1);
        }
        ////way 2

        //         if (x == 0.0f) return 0.0d;
        //         long b = n;
        //         double res = 1.0;
        //         if (b < 0) {
        //             x = 1 / x;
        //             b = -b;
        //         }
        //         while (b > 0) {
        //             if (b % 2 == 1) res *= x;
        //             x *= x;
        //             b /= 2;
        //         }
        //         return res;
    }
}
