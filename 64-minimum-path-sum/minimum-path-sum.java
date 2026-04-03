// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m=grid.length;
//         int n=grid[0].length;
        
//         int dp[][]=new int[m][n];
//         for(int i=m-1;i>=0;i--){
//             for(int j=n-1;j>=0;j--){
//                 if(i==m-1 && j==n-1){
//                     dp[i][j]=grid[i][j];
//                 }
//                 else if(i==m-1){
//                     dp[i][j]=grid[i][j]+dp[i][j+1];
//                 }
//                 else if(j==n-1){
//                     dp[i][j]=grid[i][j]+dp[i+1][j];
//                 }
//                 else{
//                     dp[i][j]=((int)Math.min(dp[i][j+1],dp[i+1][j])+grid[i][j]);
//                 }
                 
//             }
//         }
        
//         return dp[0][0];
            
//     }
// }

////way2


class Solution {
    int m, n;
    Integer[][] memo;

    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        memo = new Integer[m][n];

        return solve(0, 0, grid);
    }

    public int solve(int i, int j, int[][] grid) {
        if (i >= m || j >= n) return Integer.MAX_VALUE;

        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (memo[i][j] != null) return memo[i][j];

        int down = solve(i + 1, j, grid);
        int right = solve(i, j + 1, grid);

        return memo[i][j] = grid[i][j] + Math.min(down, right);
    }
}