// class Solution {
//     public int[][] rangeAddQueries(int n, int[][] queries) {
//         int[][] diff = new int[n + 1][n + 1];

//         // Apply 2D difference for each query
//         for (int[] q : queries) {
//             int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];

//             diff[r1][c1] += 1;
//             if (c2 + 1 < n) diff[r1][c2 + 1] -= 1;
//             if (r2 + 1 < n) diff[r2 + 1][c1] -= 1;
//             if (r2 + 1 < n && c2 + 1 < n) diff[r2 + 1][c2 + 1] += 1;
//         }

//         // Prefix sum row-wise
//         for (int r = 0; r < n; r++) {
//             for (int c = 1; c < n; c++) {
//                 diff[r][c] += diff[r][c - 1];
//             }
//         }

//         // Prefix sum col-wise
//         for (int c = 0; c < n; c++) {
//             for (int r = 1; r < n; r++) {
//                 diff[r][c] += diff[r - 1][c];
//             }
//         }

//         // Build final matrix
//         int[][] mat = new int[n][n];
//         for (int r = 0; r < n; r++) {
//             for (int c = 0; c < n; c++) {
//                 mat[r][c] = diff[r][c];
//             }
//         }

//         return mat;
//     }
// }


class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] mat = new int[n][n];

        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];

            for (int r = r1; r <= r2; r++) {
                for (int c = c1; c <= c2; c++) {
                    mat[r][c]++;
                }
            }
        }

        return mat;
    }
}
