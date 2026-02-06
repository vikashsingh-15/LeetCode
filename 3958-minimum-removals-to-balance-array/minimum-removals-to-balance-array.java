////TLE

// class Solution {
//     public int minRemoval(int[] nums, int k) {
//         Arrays.sort(nums);   
//         int n = nums.length;

//         int maxLen = 1;     

//         for (int i = 0; i < n; i++) {
//             for (int j = i; j < n; j++) {
//                 long min = nums[i];
//                 long max = nums[j];

//                 if (max <= min * k) {
//                     maxLen = Math.max(maxLen, j - i + 1);
//                 } else {
                   
//                     break;
//                 }
//             }
//         }

        
//         return n - maxLen;

        
//     }
// }

//way 2

class Solution {

    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);

        int ans = n;
        int right = 0;

        for (int left = 0; left < n; left++) {
            while (right < n && nums[right] <= (long) nums[left] * k) {
                right++;
            }
            ans = Math.min(ans, n - (right - left));
        }

        return ans;
    }
}