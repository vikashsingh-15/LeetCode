class Solution {

    public int climbStairs(int n) {
        int qb[]= new int[n + 1];
        return climbStairsMemo(n, qb);
    }

    public int climbStairsMemo(int n, int[] qb) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 0;
        }

        if (qb[n] != 0) {
            return qb[n];
        }

        int num1 = climbStairsMemo(n - 1, qb);
        int num2 = climbStairsMemo(n - 2, qb);
        qb[n] = num1 + num2;
        return num1 + num2;
    }
}
