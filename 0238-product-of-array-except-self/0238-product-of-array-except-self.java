class Solution {
    public int[] productExceptSelf(int[] nums) {
//         //way 1
//         int length = nums.length;
//         int[] answer = new int[length];
//         answer[0] = 1;
//         for (int i = 1; i < length; i++) {
//             answer[i] = nums[i - 1] * answer[i - 1];
//         }
//         int R = 1;
//         for (int i = length - 1; i >= 0; i--) {
//             answer[i] = answer[i] * R;
//             R *= nums[i];
//         }
//         return answer;
        
        //way 2
        
        int  ans[]= new int [nums.length];
        ans[nums.length-1]=nums[nums.length-1];
        
        for(int i=nums.length-2;i>=0;i--){
            ans[i]=nums[i]*ans[i+1];
        }
        
        int productSoFar=1;
        for(int i=0;i<nums.length-1;i++){             
            ans[i]=ans[i+1]* productSoFar;
             productSoFar= productSoFar*nums[i];
        }
        ans[nums.length-1]= productSoFar;
        return ans;
    }
}