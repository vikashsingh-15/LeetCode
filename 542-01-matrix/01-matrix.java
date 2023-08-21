import java.util.LinkedList;
import java.util.Queue;

class Solution {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];

        Queue<int[]> queue = new LinkedList<>();

        // Initialize result matrix with -1 and enqueue cells with value 1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    result[i][j] = -1;
                } else {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Perform BFS traversal
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && result[newRow][newCol] == -1) {
                    result[newRow][newCol] = result[row][col] + 1;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        return result;
    }
}
