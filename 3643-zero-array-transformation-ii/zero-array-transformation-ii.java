////TLE
// class Solution {
//     public int minZeroArray(int[] nums, int[][] queries) {
//       int n = nums.length;
        
//         // If nums is already a Zero Array, return 0
//         boolean alreadyZero = true;
//         for (int num : nums) {
//             if (num != 0) {
//                 alreadyZero = false;
//                 break;
//             }
//         }
//         if (alreadyZero) return 0;
        
//         for (int k = 0; k < queries.length; k++) {
//             int l = queries[k][0], r = queries[k][1], val = queries[k][2];
            
//             for (int i = l; i <= r; i++) {
//                 nums[i] = Math.max(0, nums[i] - val);
//             }
            
//             // Check if nums is a Zero Array
//             boolean isZeroArray = true;
//             for (int num : nums) {
//                 if (num != 0) {
//                     isZeroArray = false;
//                     break;
//                 }
//             }
            
//             if (isZeroArray) return k + 1;
//         }
        
//         return -1; 
//     }
// }

////way 2
class Solution {

    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, left = 0, right = queries.length;

        // Zero array isn't formed after all queries are processed
        if (!currentIndexZero(nums, queries, right)) return -1;

        // Binary Search
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (currentIndexZero(nums, queries, middle)) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }

        // Return earliest query that zero array can be formed
        return left;
    }

    private boolean currentIndexZero(int[] nums, int[][] queries, int k) {
        int n = nums.length, sum = 0;
        int[] differenceArray = new int[n + 1];

        // Process query
        for (int queryIndex = 0; queryIndex < k; queryIndex++) {
            int left = queries[queryIndex][0], right =
                queries[queryIndex][1], val = queries[queryIndex][2];

            // Process start and end of range
            differenceArray[left] += val;
            differenceArray[right + 1] -= val;
        }

        // Check if zero array can be formed
        for (int numIndex = 0; numIndex < n; numIndex++) {
            sum += differenceArray[numIndex];
            if (sum < nums[numIndex]) return false;
        }
        return true;
    }
}