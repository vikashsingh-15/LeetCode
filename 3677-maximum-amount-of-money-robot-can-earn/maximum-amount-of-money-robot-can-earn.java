class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;

        int[][][] dp = new int[m][n][3];

        // Initialize with very small values
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        // Base case (0,0)
        if (coins[0][0] >= 0) {
            dp[0][0][0] = coins[0][0];
        } else {
            dp[0][0][0] = coins[0][0]; // take loss
            dp[0][0][1] = 0;           // neutralize
        }

        // First row
        for (int j = 1; j < n; j++) {
            for (int k = 0; k <= 2; k++) {

                int val = coins[0][j];

                // take value
                if (dp[0][j - 1][k] != Integer.MIN_VALUE) {
                    dp[0][j][k] = dp[0][j - 1][k] + val;
                }

                // neutralize
                if (val < 0 && k > 0 && dp[0][j - 1][k - 1] != Integer.MIN_VALUE) {
                    dp[0][j][k] = Math.max(dp[0][j][k],
                            dp[0][j - 1][k - 1]);
                }
            }
        }

        // First column
        for (int i = 1; i < m; i++) {
            for (int k = 0; k <= 2; k++) {

                int val = coins[i][0];

                // take value
                if (dp[i - 1][0][k] != Integer.MIN_VALUE) {
                    dp[i][0][k] = dp[i - 1][0][k] + val;
                }

                // neutralize
                if (val < 0 && k > 0 && dp[i - 1][0][k - 1] != Integer.MIN_VALUE) {
                    dp[i][0][k] = Math.max(dp[i][0][k],
                            dp[i - 1][0][k - 1]);
                }
            }
        }

        // Rest of grid
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 0; k <= 2; k++) {

                    int val = coins[i][j];

                    // from top
                    if (dp[i - 1][j][k] != Integer.MIN_VALUE) {
                        dp[i][j][k] = Math.max(dp[i][j][k],
                                dp[i - 1][j][k] + val);
                    }

                    // from left
                    if (dp[i][j - 1][k] != Integer.MIN_VALUE) {
                        dp[i][j][k] = Math.max(dp[i][j][k],
                                dp[i][j - 1][k] + val);
                    }

                    // neutralize from top
                    if (val < 0 && k > 0 && dp[i - 1][j][k - 1] != Integer.MIN_VALUE) {
                        dp[i][j][k] = Math.max(dp[i][j][k],
                                dp[i - 1][j][k - 1]);
                    }

                    // neutralize from left
                    if (val < 0 && k > 0 && dp[i][j - 1][k - 1] != Integer.MIN_VALUE) {
                        dp[i][j][k] = Math.max(dp[i][j][k],
                                dp[i][j - 1][k - 1]);
                    }
                }
            }
        }

        // Final answer
        int res = Integer.MIN_VALUE;
        for (int k = 0; k <= 2; k++) {
            res = Math.max(res, dp[m - 1][n - 1][k]);
        }

        return res;
    }
}