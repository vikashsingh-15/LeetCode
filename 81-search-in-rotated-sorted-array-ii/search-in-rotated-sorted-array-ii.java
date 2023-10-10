class Solution {
    public boolean search(int[] nums, int target) {
       int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
             if (nums[left] == nums[mid]) {
                left++;
                continue;
            }
            
            if (nums[left] <= nums[mid]) { //eg - 4 5 6 7 0 1 2 target 5
                if (nums[left] <= target && target <= nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // eg - 6 7 0 1 2 4 5  target 4
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return false; 
    }
}