////case 1: TLE
// class Solution {
//     int dp[]=new int[101];
//     public int rob(int[] nums) {
//         return helper(nums,nums.length,0);
//     }

//     public int helper(int[] nums,int n,int i){
//         if(i>=n){
//             return 0;
//         }

//         if(dp[i]!=0){
//             return dp[i];
//         }

//         int steal=nums[i]+helper(nums,n,i+2);
//         int skip=helper(nums,n,i+1);
//         return dp[i]=Math.max(steal,skip);
//     }
// }

// CASE 2

class Solution {
    public int rob(int[] nums) {
       int rob = 0;
        int norob = 0;
        for (int i = 0; i < nums.length; i ++) {
            int newRob = norob + nums[i];
            int newNoRob = Math.max(norob, rob);
            rob = newRob;
            norob = newNoRob;
        }
        return Math.max(rob, norob);
    }
}