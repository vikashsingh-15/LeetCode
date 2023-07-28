class Solution {
    public boolean PredictTheWinner(int[] nums) {
        
        int n = nums.length;
        // Create a 2D DP table to store the maximum score difference for each subarray.
        int[][] dp = new int[n][n];

      

        // Fill the DP table diagonally in a bottom-up manner.
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0,j=gap; j < n;j++, i++) {
               if(gap==0){
                   dp[i][i] = nums[i];
               }else{
                    dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
               }
               
            }
        }

        // If the maximum score difference for the whole array is greater than or equal to 0,
        // then Player 1 can win; otherwise, Player 1 cannot win.
        return dp[0][n - 1] >= 0; 
        
    }
}