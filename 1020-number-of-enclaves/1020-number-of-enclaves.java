class Solution {

    public int numEnclaves(int[][] grid) {
        
        if(grid[0].length<=1){
            return 0;
        }
        int rows = grid.length;
        int col = grid[0].length;
        int no_of_islands = 0;
        for (int i = 0; i < col; i++) {
            mark_current_island(grid, 0, i);
            // mark_current_island(grid[0][i],0,i);

        }
        for (int i = 1; i < rows; i++) {
            mark_current_island(grid, i, col - 1);
            // mark_current_island(grid[i][col-1],i,col-1);
        }
        for (int i = col - 2; i >= 0; i--) {
            // mark_current_island(grid[col-1][i],col-1,i);
            mark_current_island(grid, rows - 1, i);
        }
        for (int i = rows - 2; i >= 1; i--) {
            // mark_current_island(grid[i][0],i,0);
            mark_current_island(grid, i, 0);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    no_of_islands++;
                }
            }
        }

        return no_of_islands;
    }

    void mark_current_island(int[][] grid, int x, int y) {
        int r = grid.length;
        int c = grid[0].length;
        if (x < 0 || x >= r || y < 0 || y >= c) {
            return;
        }

        if (grid[x][y] == 0) {
            return;
        }

        grid[x][y] = 0;

        mark_current_island(grid, x + 1, y);
        mark_current_island(grid, x, y + 1);
        mark_current_island(grid, x - 1, y);
        mark_current_island(grid, x, y - 1);
        // return up & down & left & right;
    }
}
