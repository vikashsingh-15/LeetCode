class Solution {

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int step = 0;
        Queue<Integer> queue = new LinkedList();
        queue.add(1);

        boolean visited[][] = new boolean[n][n];

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int k = 0; k < size; k++) {
                int x = queue.poll();
                if (x == n * n) {
                    return step;
                }

                for (int i = 1; i <= 6; i++) {
                    if (i + x > n * n) {
                        break;
                    }
                    int pos[] = rowAndCol(x + i, n);
                    int r = pos[0];
                    int c = pos[1];

                    if (visited[r][c] == true) continue;
                    visited[r][c] = true;

                        if (board[r][c] == -1) {
                            queue.add(x + i);
                        } else {
                            queue.add(board[r][c]);
                        }
                    }
                }
                step++;
            }
        return -1;
    }

    public int[] rowAndCol(int x, int n) {
        int row = (x - 1) / n;
        int col = (x - 1) % n;
        if (row % 2 != 0) {
            col = (n - col - 1);
        }
        row = n - row - 1;

        return new int[] { row, col };
    }
}
