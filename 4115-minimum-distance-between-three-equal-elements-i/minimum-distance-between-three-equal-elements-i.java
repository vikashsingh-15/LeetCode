// class Solution {

//     public int minimumDistance(int[] nums) {
//         int n = nums.length;
//         int ans = n + 1;

//         for (int i = 0; i < n - 2; i++) {
//             for (int j = i + 1; j < n - 1; j++) {
//                 if (nums[i] == nums[j]) {
//                     for (int k = j + 1; k < n; k++) {
//                     if (nums[j] == nums[k]) {
//                         ans = Math.min(ans, k - i);
//                         break;
//                     }
//                 }
//                 }
                
//             }
//         }

//         return ans == n + 1 ? -1 : ans * 2;
//     }
// }

////way 2

class Solution {
    public int minimumDistance(int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    
                    if (nums[i] == nums[j] && nums[j] == nums[k]) {
                        int dist = (j - i) + (k - j) + (k - i); // simple formula
                        ans = Math.min(ans, dist);
                    }
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}