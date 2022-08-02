class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int col = matrix[0].length;
        int row = matrix.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                pq.add(matrix[i][j]);
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        return pq.peek();
    }
}
