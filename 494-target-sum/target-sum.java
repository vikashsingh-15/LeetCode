public class Solution {
    int totalWays = 0;

    public int findTargetSumWays(int[] nums, int target) {
        helper(nums, 0, 0, target);
        return totalWays;
    }

    private void helper(int[] nums, int index, int sum, int target) {
        if (index == nums.length) {
            if (sum == target) {
                totalWays++;
            }
            return;

        } else {
            helper(nums, index + 1, sum + nums[index], target);
            helper(nums, index + 1, sum - nums[index], target);
        }
    }

}