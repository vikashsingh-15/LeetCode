// class Solution {
//     public boolean isTrionic(int[] nums) {
//         int n = nums.length;
//         if (n < 3) return false;

//         int i = 0;

//         //increasing
//         while (i + 1 < n && nums[i] < nums[i + 1]) i++;
//         if (i == 0 || i >= n - 2) return false; 

//         //decreasing
//         int peak = i;
//         while (i + 1 < n && nums[i] > nums[i + 1]) i++;
//         if (i == peak || i >= n - 1) return false; 
        
//         //increasing
//         while (i + 1 < n && nums[i] < nums[i + 1]) i++;

//         return i == n - 1;
//     }
// }



class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int upPeak = 0;
        int downPeak = 0;

        for (int i = 1; i < n - 1; i++) {
            if (nums[i - 1] == nums[i] || nums[i] == nums[i + 1]) {
                return false;
            }
            if (nums[i - 1] < nums[i] && nums[i] > nums[i + 1]) {
                upPeak++;
            }
            if (nums[i - 1] > nums[i] && nums[i] < nums[i + 1]) {
                if (upPeak != 1) {
                    return false; 
                }
                downPeak++;
            }
        }

        return upPeak == 1 && downPeak == 1;
    }
}

