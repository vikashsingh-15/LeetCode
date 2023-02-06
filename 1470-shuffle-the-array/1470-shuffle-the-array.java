class Solution {

    public int[] shuffle(int[] nums, int n) {
        ////way 1
//         int part = nums.length / n;
//         int length2 = nums.length / part;
//         int ans[]=new int [nums.length];
//         int k=0;

//         for (int i = 0; i < length2; i++) {
//             ans[k++]=nums[i];
//             for (int j = i + length2; j < nums.length; j = j + length2) {
//                 ans[k++]=nums[j];  
//             }
//         }
//         return ans;
        
        
        
        //WAY 2
        int[] result = new int[2*n];
        for(int i = 0; i < n; i ++) {
            result[2*i] = nums[i];
            result[2*i+1] = nums[i+n];
        }
        return result;
    }
}
