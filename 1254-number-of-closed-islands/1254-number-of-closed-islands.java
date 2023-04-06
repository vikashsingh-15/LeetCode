class Solution {

    public int closedIsland(int[][] grid) {
        int rows = grid.length;
        if (rows == 0) {
            return 0;
        }
        int col = grid[0].length;
        int no_of_islands = 0;
        boolean vis[][] = new boolean[rows][col];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    no_of_islands += mark_current_island(grid, i, j, rows, col);
                }
            }
        }
        return no_of_islands;
    }

    int mark_current_island(int[][] grid, int x, int y, int r, int c) {
        if (x < 0 || x >= r || y < 0 || y >= c) {
            return 0;
        }

        if (grid[x][y] == 1) {
            return 1;
        }

        grid[x][y] = 1;

        int up = mark_current_island(grid, x + 1, y, r, c);
        int down = mark_current_island(grid, x, y + 1, r, c);
        int left = mark_current_island(grid, x - 1, y, r, c);
        int right = mark_current_island(grid, x, y - 1, r, c);
        return up & down & left & right;
    }
}
