class Solution {
    public long findScore(int[] nums) {
        long ans = 0;
        int[][] dp = new int[nums.length][2];
        boolean[] marked = new boolean[nums.length];

        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = nums[i];
            dp[i][1] = i;
        }
        Arrays.sort(dp, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < nums.length; i++) {
            int x = dp[i][0];
            int index = dp[i][1];
            if (!marked[index]) {
                ans += x;
                marked[index] = true;

                if (index >= 1) {
                    marked[index - 1] = true;
                }
                if (index < nums.length - 1) {
                    marked[index + 1] = true;
                }
            }

        }
        return ans;
    }
}