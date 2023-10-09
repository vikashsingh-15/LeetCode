class Solution {

    public int[] searchRange(int[] nums, int target) {
        int[] result = { -1, -1 };

        // Find the first occurrence of the target
        int first = findFirst(nums, target);
        if (first == -1) {
            return result; // Target not found
        }

        // Find the last occurrence of the target
        int last = findLast(nums, target);

        result[0] = first;
        result[1] = last;
        return result;
    }

    private int findFirst(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int first = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else{
                first = mid;
                right = mid - 1;
            }
        }

        return first;
    }

    private int findLast(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int last = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                last = mid;
                left = mid + 1; // Continue searching in the right half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return last;
    }
}
