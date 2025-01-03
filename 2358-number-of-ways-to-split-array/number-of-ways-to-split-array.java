// class Solution {
//     public int waysToSplitArray(int[] nums) {
//         long sum=0;
//         long  preArr[]=new long [nums.length];
//         preArr[0]=nums[0];
//         sum=nums[0];
//      for(int i=1;i<nums.length;i++){
//         sum+=nums[i];
//         preArr[i]=nums[i]+preArr[i-1];

//      }  

//      int count=0;

//      for(int i=0;i<nums.length-1;i++){
//         long rightSum=sum-preArr[i];
//         if(preArr[i]>=rightSum){
//             count++;
//         }

//      } 
//     return count;

//     }
// }

//w ay 2

class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        long leftSum=0;

        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            leftSum+=nums[i];
            long rightSum = sum - leftSum;
            if (leftSum >= rightSum) {
                count++;
            }

        }
        return count;

    }
}