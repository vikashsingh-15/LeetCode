////TLE
// class Solution {
//     public int maxAbsoluteSum(int[] nums) {

//         int sum=0;
//         int max=0;

//         for(int i=0;i< nums.length;i++){
//             sum=0;
//             for(int j=i;j<nums.length;j++){
//                 sum+=nums[j];
//                 max=Math.max(max,Math.abs(sum));
//             }
//         }
//         return max;
//     }
// }

////way 2 --> using Kadens

// class Solution {
//     public int maxAbsoluteSum(int[] nums) {
//         int maxSum = nums[0], currentMax = 0;
//         int minSum = nums[0], currentMin = 0;

//         // Finding max subarray sum
//         for (int num : nums) {
//             if (currentMax < 0) currentMax = 0;
//             currentMax += num;
//             maxSum = Math.max(maxSum, currentMax);
//         }

//         // Finding min subarray sum
//         for (int num : nums) {
//             if (currentMin > 0) currentMin = 0;
//             currentMin += num;
//             minSum = Math.min(minSum, currentMin);
//         }

//         // Return the max absolute value
//         return Math.max(Math.abs(maxSum), Math.abs(minSum));
//     }
// }


////way 3

class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = nums[0], currentMax = 0;
        int minSum = nums[0], currentMin = 0;

        for(int num:nums){
            if(currentMax<0){
                currentMax=0;
            }
            currentMax+=num;
            maxSum=Math.max(currentMax,maxSum);



             if(currentMin>0){
                currentMin=0;
            }

            currentMin+=num;
            minSum=Math.min(currentMin,minSum);
        }

      return Math.max(Math.abs(maxSum), Math.abs(minSum));
    }
}
