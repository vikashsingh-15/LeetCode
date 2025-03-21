class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

   
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;  
        }

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 1;  
        }

 
        for (int[] guard : guards) {
            markGuarded(guard[0], guard[1], grid);
        }

  
        int count = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 0) count++;
            }
        }
        return count;
    }

    public void markGuarded(int row, int col, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Mark Upward
        for (int r = row - 1; r >= 0; r--) {
            if (grid[r][col] == 1) break; 
            grid[r][col] = 3; 
        }

        // Mark Downward
        for (int r = row + 1; r < m; r++) {
            if (grid[r][col] == 1 ) break;
            grid[r][col] = 3;
        }

        // Mark Leftward
        for (int c = col - 1; c >= 0; c--) {
            if (grid[row][c] == 1 ) break;
            grid[row][c] = 3;
        }

        // Mark Rightward
        for (int c = col + 1; c < n; c++) {
            if (grid[row][c] == 1) break;
            grid[row][c] = 3;
        }
    }
}
