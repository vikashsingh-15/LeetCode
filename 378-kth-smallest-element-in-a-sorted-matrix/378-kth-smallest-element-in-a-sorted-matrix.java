// class Solution {

//     public int kthSmallest(int[][] matrix, int k) {
//         int col = matrix[0].length;
//         int row = matrix.length;

//         PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

//         for (int i = 0; i < row; i++) {
//             for (int j = 0; j < col; j++) {
//                 pq.add(matrix[i][j]);
//                 if (pq.size() > k) {
//                     pq.poll();
//                 }
//             }
//         }

//         return pq.peek();
//     }
// }

class Solution {

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int low = matrix[0][0];
        int high = matrix[n - 1][n - 1];

        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = lessEqual(matrix, mid);
            if (count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int lessEqual(int[][] matrix, int target) {
        int count = 0;
        //last row ke start se check suru karenghe
        int row = matrix.length-1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] > target) {
                row--;
            } else {
                count = count + row + 1;
                col++;
            }
        }

        return count;
    }
}
