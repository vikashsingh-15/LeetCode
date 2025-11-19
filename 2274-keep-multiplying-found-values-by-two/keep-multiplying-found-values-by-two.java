// class Solution {

//     public int findFinalValue(int[] nums, int original) {
//         Arrays.sort(nums);
//         for (int num : nums) {
//             if (original == num) {
//                 original *= 2;
//             }
//         }
//         return original;
//     }
// }

//way 2

// class Solution {

//     public int findFinalValue(int[] nums, int original) {
//         Set<Integer> set = new HashSet<>();
//         for (int num : nums) {
//             set.add(num);
//         }
//         while (set.contains(original)) {
//             original *= 2;
//         }
//         return original;
//     }
// }

////way 3

import java.util.Arrays;

class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);

        while (binarySearch(nums, original)) {
            original *= 2;
        }

        return original;
    }

    private boolean binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}
