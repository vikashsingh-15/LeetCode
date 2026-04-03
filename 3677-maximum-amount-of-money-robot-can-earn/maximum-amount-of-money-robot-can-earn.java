// class Solution {
//     public int maximumAmount(int[][] coins) {
//         int m = coins.length, n = coins[0].length;

//         int[][][] dp = new int[m][n][3];

//         // Initialize with very small values
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 for (int k = 0; k < 3; k++) {
//                     dp[i][j][k] = Integer.MIN_VALUE;
//                 }
//             }
//         }

//         // Base case (0,0)
//         if (coins[0][0] >= 0) {
//             dp[0][0][0] = coins[0][0];
//         } else {
//             dp[0][0][0] = coins[0][0]; // take loss
//             dp[0][0][1] = 0;           // neutralize
//         }

//         // First row
//         for (int j = 1; j < n; j++) {
//             for (int k = 0; k <= 2; k++) {

//                 int val = coins[0][j];

//                 // take value
//                 if (dp[0][j - 1][k] != Integer.MIN_VALUE) {
//                     dp[0][j][k] = dp[0][j - 1][k] + val;
//                 }

//                 // neutralize
//                 if (val < 0 && k > 0 && dp[0][j - 1][k - 1] != Integer.MIN_VALUE) {
//                     dp[0][j][k] = Math.max(dp[0][j][k],
//                             dp[0][j - 1][k - 1]);
//                 }
//             }
//         }

//         // First column
//         for (int i = 1; i < m; i++) {
//             for (int k = 0; k <= 2; k++) {

//                 int val = coins[i][0];

//                 // take value
//                 if (dp[i - 1][0][k] != Integer.MIN_VALUE) {
//                     dp[i][0][k] = dp[i - 1][0][k] + val;
//                 }

//                 // neutralize
//                 if (val < 0 && k > 0 && dp[i - 1][0][k - 1] != Integer.MIN_VALUE) {
//                     dp[i][0][k] = Math.max(dp[i][0][k],
//                             dp[i - 1][0][k - 1]);
//                 }
//             }
//         }

//         // Rest of grid
//         for (int i = 1; i < m; i++) {
//             for (int j = 1; j < n; j++) {
//                 for (int k = 0; k <= 2; k++) {

//                     int val = coins[i][j];

//                     // from top
//                     if (dp[i - 1][j][k] != Integer.MIN_VALUE) {
//                         dp[i][j][k] = Math.max(dp[i][j][k],
//                                 dp[i - 1][j][k] + val);
//                     }

//                     // from left
//                     if (dp[i][j - 1][k] != Integer.MIN_VALUE) {
//                         dp[i][j][k] = Math.max(dp[i][j][k],
//                                 dp[i][j - 1][k] + val);
//                     }

//                     // neutralize from top
//                     if (val < 0 && k > 0 && dp[i - 1][j][k - 1] != Integer.MIN_VALUE) {
//                         dp[i][j][k] = Math.max(dp[i][j][k],
//                                 dp[i - 1][j][k - 1]);
//                     }

//                     // neutralize from left
//                     if (val < 0 && k > 0 && dp[i][j - 1][k - 1] != Integer.MIN_VALUE) {
//                         dp[i][j][k] = Math.max(dp[i][j][k],
//                                 dp[i][j - 1][k - 1]);
//                     }
//                 }
//             }
//         }

//         // Final answer
//         int res = Integer.MIN_VALUE;
//         for (int k = 0; k <= 2; k++) {
//             res = Math.max(res, dp[m - 1][n - 1][k]);
//         }

//         return res;
//     }
// }

//// way 2 --> Recursion --> TLE

// class Solution {
//     int m;
//     int n;

//     public int maximumAmount(int[][] coins) {
//         m = coins.length;

//         n = coins[0].length;
//         return solve(0, 0, coins, 2);
//     }

//     public int solve(int i, int j, int[][] coins, int neuLeft) {
//         if (i == m - 1 && j == n - 1) {
//             if (coins[i][j] < 0 && neuLeft > 0) {
//                 return 0;
//             } else {
//                 return coins[i][j];
//             }
//         }

//         if (i >= m || j >= n) {
//             return Integer.MIN_VALUE;
//         }

//         int val = coins[i][j];

//         //take 
//         int take = coins[i][j] + Math.max(solve(i + 1, j, coins, neuLeft), solve(i, j + 1, coins, neuLeft));

//         //Nuetralize
//         int skip = Integer.MIN_VALUE;

//         if (val < 0 && neuLeft > 0) {
//             int skipDown = solve(i + 1, j, coins, neuLeft - 1);
//             int skipRight = solve(i, j + 1, coins, neuLeft - 1);

//             skip = Math.max(skipDown, skipRight);
//         }

//         return Math.max(skip, take);
//     }
// }

//// way 3 --> Recursion

class Solution {
    int m;
    int n;
    int dp[][][];

    public int maximumAmount(int[][] coins) {
        m = coins.length;

        n = coins[0].length;
        dp = new int[m][n][3];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }

        return solve(0, 0, coins, 2);
    }

    public int solve(int i, int j, int[][] coins, int neuLeft) {
        if (i == m - 1 && j == n - 1) {
            if (coins[i][j] < 0 && neuLeft > 0) {
                return 0;
            } else {
                return coins[i][j];
            }
        }

        if (i >= m || j >= n) {
            return Integer.MIN_VALUE;
        }

        if(dp[i][j][neuLeft]!=Integer.MIN_VALUE){
            return dp[i][j][neuLeft];
        }

        int val = coins[i][j];

        //take 
        int take = coins[i][j] + Math.max(solve(i + 1, j, coins, neuLeft), solve(i, j + 1, coins, neuLeft));

        //Nuetralize
        int skip = Integer.MIN_VALUE;

        if (val < 0 && neuLeft > 0) {
            int skipDown = solve(i + 1, j, coins, neuLeft - 1);
            int skipRight = solve(i, j + 1, coins, neuLeft - 1);

            skip = Math.max(skipDown, skipRight);
        }

        return dp[i][j][neuLeft]=Math.max(skip, take);
    }
}
