class Solution {

    public int singleNonDuplicate(int[] nums) {
        // int left = 0, right = nums.length - 1;
        // while (left < right) {
        //     int mid = (left + right) / 2;
        //     if (mid % 2 == 1) {
        //         mid--;
        //     }
        //     if (nums[mid] != nums[mid + 1]) {
        //         right = mid;
        //     } else {
        //         left = mid + 2;
        //     }
        // }
        // return nums[left];

        //way 2

        //  int ans = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     ans = ans ^ nums[i];
        // }
        // return ans;

        //way 3
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == nums[mid + 1]) {
// If mid is even, the left side has pairs, and single is on the right
                if (mid % 2 == 0) {
                    left = mid + 2;
                } else {
// If mid is odd, the right side has pairs, and single is on the left
                    right = mid - 1;
                }
            } else {
// If mid is even, the left side has pairs, and single is on the left
                if (mid % 2 == 0) {
                    right = mid;
                } else {
// If mid is odd, the right side has pairs, and single is on the right
                    left = mid + 1;
                }
            }
        }

        return nums[left];
    }
}
