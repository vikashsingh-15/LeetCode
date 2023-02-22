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

        // //Way 2
        //         int low = 0;
        //         int high = nums.length-2;
        //         while(low <= high) {
        //             int mid = low + (high - low) / 2;
        //             if(nums[mid] == nums[mid^1]) {
        //                 low = mid + 1;
        //             }
        //             else {
        //                 high = mid - 1;
        //             }
        //         }
        //         return nums[low];
        //way 3
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }
        return ans;
    }
}
