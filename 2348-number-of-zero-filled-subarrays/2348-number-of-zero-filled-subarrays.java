class Solution {
    public long zeroFilledSubarray(int[] nums) {
         long res = 0;
        int apoint=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                apoint = i + 1;
            res += i - apoint + 1;
        }
        return res;
    }
}