//Way 1 --> Its correct but fail due too  overflow of int
// class Solution {
//     public int[][] constructProductMatrix(int[][] grid) {
//         long product = 1;

//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 product *= grid[i][j];
//             }
//         }

//         int[][] ans = new int[grid.length][grid[0].length];

//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 ans[i][j] = (int)((product / grid[i][j]) % 12345);
//             }
//         }

//         return ans;
//     }
// }

////way 2

class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
         int n = grid.length, m = grid[0].length;
        int mod = 12345;

        int[][] ans = new int[n][m];


         long prefix = 1;

        // Step 1: Prefix pass
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[i][j] = (int)(prefix % mod);
                prefix = (prefix * grid[i][j]) % mod;
            }
        }

        long suffix=1;

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                ans[i][j]=(int)((ans[i][j] * suffix) % mod);
                suffix = (suffix * grid[i][j]) % mod;
            }
        }

        return ans;
    }
}