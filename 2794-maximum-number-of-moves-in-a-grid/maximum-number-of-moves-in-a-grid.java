// class Solution {
//     int dp[][];
//     int m,n;
//     public int maxMoves(int[][] grid) {
//          m = grid.length;
//          n = grid[0].length;
//         dp = new int[m][n];
//         int maxMoves = 0;

//         for(int i=0;i<m;i++){
//              maxMoves = Math.max(maxMoves, dfs(grid, i, 0));
//         }
//         return maxMoves;
//     }

//      private int dfs(int[][] grid, int row, int col) {

//         if(col==n-1)return 0;

//         if(dp[row][col]!=0){
//             return dp[row][col];
//         }

//         int maxSteps=0;

//         if (col + 1 < n && grid[row][col + 1] > grid[row][col]) {
//             maxSteps = Math.max(maxSteps, 1 + dfs(grid, row, col + 1));
//         }
//         if (row - 1 >= 0 && col + 1 < n && grid[row - 1][col + 1] > grid[row][col]) {
//             maxSteps = Math.max(maxSteps, 1 + dfs(grid, row - 1, col + 1));
//         }
//         if (row + 1 < m && col + 1 < n && grid[row + 1][col + 1] > grid[row][col]) {
//             maxSteps = Math.max(maxSteps, 1 + dfs(grid, row + 1, col + 1));
//         }

//         dp[row][col] = maxSteps;
//         return maxSteps;

//      }
// }


////way 2

 class Solution {
    public int maxMoves(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;
        int dp[][] =new int [m][n];

        int max=0;

        for(int col=n-1;col>=0;col--){
            for(int row=0;row<m;row++){

                int side=0;
                int diagUp=0;
                int diagDown=0;

               if (row - 1 >= 0 &&  col+1<n  && grid[row - 1][col + 1] > grid[row][col]) {
                    diagUp = dp[row - 1][col + 1] + 1;
                }
                if (col + 1 < n  && grid[row][col + 1] > grid[row][col]) {
                    side = dp[row][col + 1] + 1;
                }
                if (row + 1 < m && col+1<n && grid[row + 1][col + 1] > grid[row][col]) {
                    diagDown = dp[row + 1][col + 1] + 1;
                }

                dp[row][col] = Math.max(diagUp, Math.max(side, diagDown));
                
                if(col==0){
                    max=Math.max(max,dp[row][col]);
                }

            }

        }

        return max;
    }
}