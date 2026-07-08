// class Solution {
//      private static final int MOD = 1000000007;
//     public int[] sumAndMultiply(String s, int[][] queries) {
//         int n = s.length();
//         int[] sum = new int[n + 1];
//         long[] x = new long[n + 1];
//         int[] cnt = new int[n + 1];
//         for (int i = 0; i < n; ++i) {
//             int d = s.charAt(i) - '0';
//             sum[i + 1] = sum[i] + d;
//             x[i + 1] = d > 0 ? (x[i] * 10 + d) % MOD : x[i];
//             cnt[i + 1] = cnt[i] + (d > 0 ? 1 : 0);
//         }

//        int m = queries.length;
//         int[] res = new int[m];
//         for (int i = 0; i < m; ++i) {
//             int l = queries[i][0];
//             int r = queries[i][1] + 1;
//             int length = cnt[r] - cnt[l];
//             long val_sum = sum[r] - sum[l];
//             long val_x = (long)(x[r] - ((x[l] * Math.pow(10, length)) % MOD) + MOD) % MOD;
//             res[i] = (int) ((val_x * val_sum) % MOD);

//         }
//         return res;

//     }
// }

// way 2 -> above is wrong sincs double has its limit an dmath.pow give double 

class Solution {
    private static final int MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        int[] sum = new int[n + 1];
        long[] x = new long[n + 1];
        int[] cnt = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            int d = s.charAt(i) - '0';
            sum[i + 1] = sum[i] + d;
            x[i + 1] = d > 0 ? (x[i] * 10 + d) % MOD : x[i];
            cnt[i + 1] = cnt[i] + (d > 0 ? 1 : 0);
        }

        long[] pow10 = new long[100001];
        pow10[0] = 1;

        for (int i = 1; i < pow10.length; i++) {
           pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; ++i) {
            int l = queries[i][0];
            int r = queries[i][1] + 1;
            int length = cnt[r] - cnt[l];
            long val_sum = sum[r] - sum[l];
            long val_x = (long) (x[r] - ((x[l] * pow10[length]) % MOD) + MOD) % MOD;
            res[i] = (int) ((val_x * val_sum) % MOD);

        }
        return res;

    }
}