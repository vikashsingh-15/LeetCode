// class Solution {
//     public boolean validPartition(int[] nums) {
//        int n=nums.length;
//         boolean dp[]=new boolean[n+1];
//         dp[n]=true;
//         for(int i=n-1;i>=0;i--){
//             if(i+1<n){
// 				//cond.1 for 2 same ele
//                 if(nums[i]==nums[i+1] && dp[i+2]){
//                     dp[i]=true;
//                 }
//                 if(i+2<n){
// 					//cond. 2 for 3 same ele
// 					//cond. 3 for difference between adjacent elements is 1.
//                     if( ( (nums[i]==nums[i+1] && nums[i+1]==nums[i+2]) || (nums[i]+1==nums[i+1] && nums[i+1]+1==nums[i+2]) ) && dp[i+3] ){
//                         dp[i]=true;
//                     }
//                 }
//             }
//         }
//         return dp[0];
//     }
// }

class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[n] = true;

        for (int i = n - 1; i >= 0; i--) {
            if (i + 1 < n && ((nums[i] == nums[i + 1] && dp[i + 2]==true))) {
                dp[i] = true;
            }

            if (i + 2 < n && (((nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) || (nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2])) && dp[i + 3]==true)) {
                dp[i] = true;
            }
        }

        return dp[0];
    }
}

