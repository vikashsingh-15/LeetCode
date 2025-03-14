
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

// ////way 2
// class Solution {
//     public int minZeroArray(int[] arr, int[][] queries) {
//         int n = arr.length;
//         int q = queries.length;

//         if (checkZero(arr)) {
//             return 0;
//         }

//         for (int i = 0; i < q; i++) {
//             if (diffArrayZero(arr, queries, i + 1)) { 
//                 return i + 1;
//             }
//         }

//         return -1;
//     }

//     private boolean diffArrayZero(int arr[], int[][] queries, int k) {
//         int[] diff = new int[arr.length + 1]; 

//         for (int i = 0; i < k; i++) {
//             int l = queries[i][0];
//             int r = queries[i][1];
//             int x = queries[i][2]; 

//             diff[l] += x;
//             if (r + 1 < arr.length) {
//                 diff[r + 1] -= x;
//             }
//         }

//         int cumSum = 0;
//         for (int i = 0; i < arr.length; i++) {
//             cumSum += diff[i];  
//             if (arr[i] - cumSum > 0) { 
//                 return false;
//             }
//         }
//         return true;
//     }

//     private boolean checkZero(int arr[]) {
//         for (int num : arr) {
//             if (num != 0) {
//                 return false;
//             }
//         }
//         return true;
//     }
// }


////way 3
class Solution {
    public int minZeroArray(int[] arr, int[][] queries) {
        int n = arr.length;
        int q = queries.length;

        if (checkZero(arr)) {
            return 0;
        }

        int left = 1, right = q, result = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (diffArrayZero(arr, queries, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private boolean diffArrayZero(int arr[], int[][] queries, int k) {
        int[] diff = new int[arr.length + 1]; 

        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int x = queries[i][2]; 

            diff[l] += x;
            if (r + 1 < arr.length) {
                diff[r + 1] -= x;
            }
        }

        int cumSum = 0;
        for (int i = 0; i < arr.length; i++) {
            cumSum += diff[i];  
            if (arr[i] - cumSum > 0) { 
                return false;
            }
        }
        return true;
    }

    private boolean checkZero(int arr[]) {
        for (int num : arr) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
}