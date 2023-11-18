class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int operations = 0;
        int maxFrequency = 0;

        for (int right = 0; right < nums.length; right++) {
            operations += nums[right];

            while ((right - left + 1) * nums[right] - operations > k) {
                operations -= nums[left];
                left++;
            }

            maxFrequency = Math.max(maxFrequency, right - left + 1);
        }

        return maxFrequency;
    }
}