class Solution {
    public int countSubmatrices(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        int count = 0;

        dp[0][0] = grid[0][0];
        if (dp[0][0] <= k) count++;

        // first row
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
            if (dp[0][j] <= k) count++;
        }

        // first column
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
            if (dp[i][0] <= k) count++;
        }

        // rest
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = grid[i][j]
                         + dp[i - 1][j]
                         + dp[i][j - 1]
                         - dp[i - 1][j - 1];

                if (dp[i][j] <= k) count++;
            }
        }

        return count;
    }
}