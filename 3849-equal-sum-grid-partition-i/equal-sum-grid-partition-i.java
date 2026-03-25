class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        long[] row = new long[n];
        long[] cols = new long[m];

        // Calculate row & column sums
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                row[i] += grid[i][j];
                cols[j] += grid[i][j];
            }
        }

        // Row partition
        long totalRow = 0;
        for (long val : row) totalRow += val;

        long curr = 0;
        for (int i = 0; i < n; i++) { 
            curr += row[i];
            if (curr * 2 == totalRow) return true;
        }

        // Column partition
        long totalCol = 0;
        for (long val : cols) totalCol += val;

        curr = 0;
        for (int j = 0; j < m ; j++) { 
            curr += cols[j];
            if (curr * 2 == totalCol) return true;
        }

        return false;
    }
}