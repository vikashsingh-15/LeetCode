class Solution {

    public long maxRunTime(int n, int[] batteries) {
        long sumPower = 0;
        for (int power : batteries) {
            sumPower += power;
        }
        long left = 1, right = sumPower;

        while (left < right) {
            long mid = (left + right+1) / 2;
            if (check(batteries, n, mid)) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        return right;
        //return left;
    }

    public boolean check(int[] B, int n, long time) {
        long sum = 0;
        for (int battery : B) {
            sum += Math.min(battery, time);
        }
        return (sum >= (long) time * n);
    }
}
