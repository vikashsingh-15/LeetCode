import java.util.*;

class Solution {
    public long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;

        long[][] arr = new long[n][2];

        for (int i = 0; i < n; i++) {
            long t = (health[i] + power - 1) / power;
            arr[i][0] = t;
            arr[i][1] = damage[i];
        }

        Arrays.sort(arr, (a, b) -> {
            double t1 = a[0], d1 = a[1];
            double t2 = b[0], d2 = b[1];
            return Double.compare(d2 / t2, d1 / t1);
        });

        long time = 0;
        long total = 0;

        for (long[] e : arr) {
            time += e[0];
            total += e[1] * time;
        }

        return total;
    }
}