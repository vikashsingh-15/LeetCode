class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int apoint = 0;
        int bpoint = nums.length - 1;

        while (apoint < bpoint) {
            while (apoint < bpoint && nums[apoint] % 2 == 0) {
                apoint++;
            }
            while (apoint < bpoint && nums[bpoint] % 2 != 0) {
                bpoint--;
            }

            // Swap nums[apoint] and nums[bpoint]
            int temp = nums[apoint];
            nums[apoint] = nums[bpoint];
            nums[bpoint] = temp;
        }

        return nums;
    }
}