class Solution {
    public int[][] updateMatrix(int[][] mat) {
         int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();

        // Initialize result matrix with maximum possible distance
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j});
                } else {
                    result[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    if (result[newRow][newCol] > result[row][col] + 1) {
                        result[newRow][newCol] = result[row][col] + 1;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        return result;
    }
}