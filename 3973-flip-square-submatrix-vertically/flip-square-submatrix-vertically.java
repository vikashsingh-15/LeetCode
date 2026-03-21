// class Solution {
//     public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

//         int p = x + k - 1;

//         for (int i = x; i < x + k / 2; i++) {  // only half
//             for (int j = y; j < y + k; j++) {  
//                 int temp = grid[i][j];
//                 grid[i][j] = grid[p][j];
//                 grid[p][j] = temp;
//             }
//             p--;
//         }

//         return grid;
//     }
// }


class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {

        int top = x;
        int bottom = x + k - 1;

        while (top < bottom) {
            for (int j = y; j < y + k; j++) {
                int temp = grid[top][j];
                grid[top][j] = grid[bottom][j];
                grid[bottom][j] = temp;
            }
            top++;
            bottom--;
        }

        return grid;
    }
}