class Solution {

    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] length = new int[n];
        int[] count = new int[n]; 

        Arrays.fill(count, 1);
        Arrays.fill(length, 1);

        int max = 1;
        for (int i = 1; i < n; i++) {
            for (int prev = 0; prev <= i; prev++) {
                if (nums[prev] < nums[i] && length[prev] + 1 > length[i]) {
                    length[i] = length[prev] + 1;
                    count[i] = count[prev];
                } else if (nums[prev] < nums[i] && length[prev] + 1 == length[i]) {
                    count[i] += count[prev];
                }
            }
            max = (int) Math.max(max, length[i]);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (length[i] == max) {
                result += count[i];
            }
        }
        return result;
    }
}
