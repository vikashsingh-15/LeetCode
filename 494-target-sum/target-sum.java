class Solution {
    int totalWays=0;
    public int findTargetSumWays(int[] nums, int target) {
        helper(nums,0,0,target);
        return totalWays;        
    }
    private void helper(int[] nums, int index, int sum, int target) {
    if (index == nums.length) { // Base case: processed all elements
        if (sum == target) {
            totalWays++;
        }
        return; // Stop recursion here
    }
    // Recursive calls for adding and subtracting the current number
    helper(nums, index + 1, sum + nums[index], target);
    helper(nums, index + 1, sum - nums[index], target);
}
}