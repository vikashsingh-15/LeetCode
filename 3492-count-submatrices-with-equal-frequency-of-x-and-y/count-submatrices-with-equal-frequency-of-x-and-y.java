class Solution {

    class Pair {
        int x, y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Pair[][] dp = new Pair[n][m];
        int count = 0;

        // Base case (0,0)
        int x = (grid[0][0] == 'X') ? 1 : 0;
        int y = (grid[0][0] == 'Y') ? 1 : 0;
        dp[0][0] = new Pair(x, y);

        if (x == y && x > 0) count++;

        // First column
        for (int i = 1; i < n; i++) {
            int addX = (grid[i][0] == 'X') ? 1 : 0;
            int addY = (grid[i][0] == 'Y') ? 1 : 0;

            dp[i][0] = new Pair(
                dp[i - 1][0].x + addX,
                dp[i - 1][0].y + addY
            );

            if (dp[i][0].x == dp[i][0].y && dp[i][0].x > 0) {
                count++;
            }
        }

        // First row
        for (int j = 1; j < m; j++) {
            int addX = (grid[0][j] == 'X') ? 1 : 0;
            int addY = (grid[0][j] == 'Y') ? 1 : 0;

            dp[0][j] = new Pair(
                dp[0][j - 1].x + addX,
                dp[0][j - 1].y + addY
            );

            if (dp[0][j].x == dp[0][j].y && dp[0][j].x > 0) {
                count++;
            }
        }

        // Rest of matrix
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {

                int addX = (grid[i][j] == 'X') ? 1 : 0;
                int addY = (grid[i][j] == 'Y') ? 1 : 0;

                int countX = dp[i - 1][j].x + dp[i][j - 1].x - dp[i - 1][j - 1].x + addX;
                int countY = dp[i - 1][j].y + dp[i][j - 1].y - dp[i - 1][j - 1].y + addY;

                dp[i][j] = new Pair(countX, countY);

                if (countX == countY && countX > 0) {
                    count++;
                }
            }
        }

        return count;
    }
}