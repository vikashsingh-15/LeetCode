class Solution {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(count, 1);
        dp[0] = 1;
        int ans = 0;

        for (int i = 1; i < n; i++) {
            int max = 0;
            int k = 0;
            for (int prev = 0; prev < i; prev++) {
                if (nums[prev] < nums[i]) {
                    if (dp[prev] > max) {
                        max = dp[prev];
                        k = 0;
                    }
                    if (dp[prev] == max) {
                        k += count[prev];
                    }
                }
            }
            dp[i] = max + 1;
            count[i] = Math.max(1, k);
            ans = Math.max(ans, dp[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] == ans) {
                result += count[i];
            }
        }
        return result;
    }
}
