import java.util.Arrays;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); 
        int maxLIS = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    int newLen=dp[j]+1;
                    dp[i]=Math.max(dp[i],newLen);
                    // dp[i] = Math.max(dp[i], dp[j] + 1); 
                }
            }
            maxLIS = Math.max(maxLIS, dp[i]); 
        }

        return maxLIS;
    }
}
