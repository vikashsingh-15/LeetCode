import java.util.*;

public class Solution {
    public int[][] highestPeak(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] height = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize the height matrix and enqueue all water cells (value = 1)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    height[i][j] = 0;  
                    queue.offer(new int[]{i, j});  
                } else {
                    height[i][j] = -1;
                }
            }
        }

        // Directions for moving up, down, left, right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // Perform BFS to calculate heights
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                // If the neighbor is within bounds and not yet visited (height = -1)
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && height[nx][ny] == -1) {
                    height[nx][ny] = height[x][y] + 1;  // Assign height
                    queue.offer(new int[]{nx, ny});  // Add the neighbor to the queue
                }
            }
        }

        return height;
    }
}
