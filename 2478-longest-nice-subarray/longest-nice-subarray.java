class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans = 0;

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            int prev = 0;

            for (int j = i; j < nums.length; j++) {
                if ((prev & nums[j]) == 0) {
                    prev |= nums[j];
                    count++;
                    ans = Math.max(ans, count);
                } else {
                    break;
                }
            }
        }

        return ans;
    }
}
