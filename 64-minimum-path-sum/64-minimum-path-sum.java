class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        
        int dp[][]=new int[m][n];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    dp[i][j]=grid[i][j];
                }
                else if(i==m-1){
                    dp[i][j]=grid[i][j]+dp[i][j+1];
                }
                else if(j==n-1){
                    dp[i][j]=grid[i][j]+dp[i+1][j];
                }
                else{
                    dp[i][j]=((int)Math.min(dp[i][j+1],dp[i+1][j])+grid[i][j]);
                }
                 
            }
        }
        
        return dp[0][0];
         
        
        /*
        int height = grid.length;
        int width = grid[0].length;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if(row == 0 && col == 0) grid[row][col] = grid[row][col];
                else if(row == 0 && col != 0) grid[row][col] = grid[row][col] + grid[row][col - 1];
                else if(col == 0 && row != 0) grid[row][col] = grid[row][col] + grid[row - 1][col];
                else grid[row][col] = grid[row][col] + Math.min(grid[row - 1][col], grid[row][col - 1]);
            }
        }
        return grid[height - 1][width - 1];
        */
        
        
        }
        
}