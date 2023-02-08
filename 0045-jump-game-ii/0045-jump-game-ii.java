class Solution {

    public int jump(int[] nums) {
        Integer dp[] = new Integer[nums.length];
        dp[nums.length - 1] = 0;
        int steps = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            steps = nums[i];
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= steps && i + j < nums.length; j++) {
                if (dp[i + j] != null) {
                    min = Math.min(dp[i + j], min);
                }
                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }
        return dp[0];
    }
}
