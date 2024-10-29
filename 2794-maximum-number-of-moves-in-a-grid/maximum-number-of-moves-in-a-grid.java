class Solution {
    public int maxMoves(int[][] grid) {
          int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m][n];

        int max=-1;
        for(int j=n-2;j>=0;j--){
            for(int i=0;i<m;i++){
                int diagUp=-1;
                int diagDown=-1;
                int side=-1;
                if(j+1<n && grid[i][j + 1] > grid[i][j]){
                    side=dp[i][j+1];
                }
                if(i-1>=0 && j+1<n && grid[i - 1][j + 1] > grid[i][j]){
                    diagUp=dp[i-1][j+1];
                }
                if(i+1<m && j+1<n && grid[i + 1][j + 1] > grid[i][j]){
                    diagDown=dp[i+1][j+1];
                }

                dp[i][j]=Math.max(side,Math.max(diagUp,diagDown))+1;
                if(j==0){
                    max=Math.max(max,dp[i][j]);
                }

            }
        }
        return max;
    }
}