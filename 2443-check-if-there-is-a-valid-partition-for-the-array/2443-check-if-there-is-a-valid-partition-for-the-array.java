// class Solution {
//     public boolean validPartition(int[] nums) {
//         int n = nums.length;
//         boolean[] dp = new boolean[n + 1];
//         dp[n] = true;

//         for (int i = n - 1; i >= 0; i--) {
//             if (i + 1 < n && ((nums[i] == nums[i + 1] && dp[i + 2]==true))) {
//                 dp[i] = true;
//             }

//             if (i + 2 < n && (((nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) || (nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2])) && dp[i + 3]==true)) {
//                 dp[i] = true;
//             }
//         }

//         return dp[0];
//     }
// }

class Solution {
    public boolean validPartition(int[] nums) {
       return helper(nums,0, new Boolean[nums.length]);
    }
    public boolean helper(int[] nums,int i,Boolean[] dp){
       if (i == nums.length) {
            return true;
        }

        if (dp[i] != null) {
            return dp[i];
        }
        
        boolean result = false;
        
        if (i + 1 < nums.length && (nums[i] == nums[i + 1])) {
            result = helper(nums, i + 2, dp);
        }
        
        if (result == true) {
            return true;
        }

        if ((i + 2) < nums.length && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2]) {
            result = helper(nums, i + 3, dp);
        }
        
        if (result == true) {
            return true;
        }

        if (i + 2 < nums.length &&( (nums[i] + 1 == nums[i + 1]) && (nums[i] + 2 == nums[i + 2]))) {
            result = helper(nums, i + 3, dp);
        }
        
        
        return dp[i] = result;
    }
}


