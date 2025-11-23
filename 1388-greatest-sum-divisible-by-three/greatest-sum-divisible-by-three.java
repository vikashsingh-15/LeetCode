// public class Solution {
//     int maxSum = 0;
//     public int maxSumDivThree(int[] nums) {
//         dfs(nums, 0, 0);
//         return maxSum;
//     }
//     private void dfs(int[] nums, int index, int currSum) {

//         // base case: reached end
//         if (index == nums.length) {
//             if (currSum % 3 == 0) {
//                 maxSum = Math.max(maxSum, currSum);
//             }
//             return;
//         }

//         // OPTION 1 → include nums[index]
//         dfs(nums, index + 1, currSum + nums[index]);

//         // OPTION 2 → exclude nums[index]
//         dfs(nums, index + 1, currSum);
//     }
// }

//

import java.util.HashMap;

public class Solution {

    HashMap<String, Integer> memo = new HashMap<>();

    public int maxSumDivThree(int[] nums) {
        return dfs(nums, 0, 0);
    }

    private int dfs(int[] nums, int index, int remainder) {

        // Base case
        if (index == nums.length) {
            return (remainder == 0) ? 0 : Integer.MIN_VALUE;
        }

        // Create unique key
        String key = index + "_" + remainder;

        // Memo lookup
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        // OPTION 1 → include nums[index]
        int newRem = (remainder + nums[index]) % 3;
        int include = nums[index] + dfs(nums, index + 1, newRem);

        // OPTION 2 → exclude nums[index]
        int exclude = dfs(nums, index + 1, remainder);

        // Best value
        int best = Math.max(include, exclude);

        // Store in memo
        memo.put(key, best);

        return best;
    }
}
