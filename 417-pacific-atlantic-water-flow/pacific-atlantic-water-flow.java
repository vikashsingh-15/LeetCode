import java.util.*;

class Solution {
    int m, n;
    private int[] rowDir = {-1, 0, 1, 0};
    private int[] colDir = {0, 1, 0, -1};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific Ocean -> top row & left column
        for (int i = 0; i < m; i++) {
            dfs(i, 0, heights, pacific);       
            dfs(i, n - 1, heights, atlantic);  
        }

        for (int j = 0; j < n; j++) {
            dfs(0, j, heights, pacific);       
            dfs(m - 1, j, heights, atlantic);  
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }

    private void dfs(int row, int col, int[][] heights, boolean[][] visited) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int x = row + rowDir[i];
            int y = col + colDir[i];

            if (x < 0 || x >= m || y < 0 || y >= n) continue;

            if (visited[x][y] || heights[x][y] < heights[row][col]) continue;

            dfs(x, y, heights, visited);
        }
    }
}
