class Solution {
    public int sortPermutation(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n];

        for (int i = 0; i < n; i++) pos[nums[i]] = i;

        int minn = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] == i) continue;
            int p = pos[i];
            minn = minn & nums[i] & nums[p];
        }

        return minn == Integer.MAX_VALUE ? 0 : minn;
    }
}