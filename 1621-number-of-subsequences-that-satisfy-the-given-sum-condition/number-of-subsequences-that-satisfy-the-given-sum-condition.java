class Solution {
    public int numSubseq(int[] nums, int target) {
         int MOD = 1000000007;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int result = 0;
        
        int[] powerOfTwo = new int[nums.length];
        powerOfTwo[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            powerOfTwo[i] = (powerOfTwo[i - 1] * 2) % MOD;
        }
        
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                result = (result + powerOfTwo[right - left]) % MOD;
                left++;
            }
        }
        
        return result;
    }
}