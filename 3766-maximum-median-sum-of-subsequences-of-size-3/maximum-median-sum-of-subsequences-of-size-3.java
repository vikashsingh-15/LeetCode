class Solution {
    public long maximumMedianSum(int[] nums) {
         Arrays.sort(nums);
        int n = nums.length;
        int k = n / 3;
        long sum = 0;
        for (int i = n - 2; i >= k ; i -= 2) {
            sum += nums[i];
        }
        return sum;
    }
}