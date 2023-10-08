class Solution {
    public int maxDotProduct(int[] nums1, int[] nums2) {
          int m = nums1.length;
    int n = nums2.length;
    
    // Create a 2D array dp to store the maximum dot product for subsequences
    int[][] dp = new int[m][n];
    
    // Initialize dp[0][0]
    dp[0][0] = nums1[0] * nums2[0];
    
    // Fill the first row of dp
    for (int j = 1; j < n; j++) {
        dp[0][j] = Math.max(dp[0][j - 1], nums1[0] * nums2[j]);
    }
    
    // Fill the first column of dp
    for (int i = 1; i < m; i++) {
        dp[i][0] = Math.max(dp[i - 1][0], nums1[i] * nums2[0]);
    }
    
    // Fill the rest of the dp array
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            // Calculate the current cell's value
            int currentProduct = nums1[i] * nums2[j];
            dp[i][j] = Math.max(
                Math.max(dp[i - 1][j], dp[i][j - 1]),
                Math.max(currentProduct, dp[i - 1][j - 1] + currentProduct)
            );
        }
    }
    
    // The result is stored in dp[m-1][n-1]
    return dp[m - 1][n - 1];
    }
}