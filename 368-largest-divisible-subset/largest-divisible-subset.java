////TLE
// class Solution {
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         Arrays.sort(nums);  
//         List<Integer> result = new ArrayList<>();
//         dfs(nums, 0, new ArrayList<>(), result);
//         return result;
//     }

//     private void dfs(int[] nums, int index, List<Integer> current, List<Integer> result) {
//         if (current.size() > result.size()) {
//             result.clear();
//             result.addAll(current);
//         }

//         for (int i = index; i < nums.length; i++) {
//             if (current.isEmpty() || nums[i] % current.get(current.size() - 1) == 0) {
//                 current.add(nums[i]);
//                 dfs(nums, i + 1, current, result);
//                 current.remove(current.size() - 1);  // Backtrack
//             }
//         }
//     }
// }

////way 2 TLE

// class Solution {
//     public List<Integer> largestDivisibleSubset(int[] nums) {
//         Arrays.sort(nums);
//         List<Integer> result = new ArrayList<>();
//         dfs(nums, 0, new ArrayList<>(), result, -1);
//         return result;
//     }

//     private void dfs(int[] nums, int index, List<Integer> current, List<Integer> result, int prev) {
//         if (index >= nums.length) {
//             if (current.size() > result.size()) {
//                 result.clear();
//                 result.addAll(current);
//             }
//             return;
//         }

//         if (prev == -1 || nums[index] % prev == 0) {
//             current.add(nums[index]);
//             dfs(nums, index + 1, current, result, nums[index]);
//             current.remove(current.size() - 1);
//         }

//         dfs(nums, index + 1, current, result, prev);

//     }
// }

////way 3
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();

        Arrays.sort(nums); // Important: to make divisible sequences easier to find

        int[] dp = new int[n];       // dp[i] = length of largest subset ending at i
        int[] prev = new int[n];     // prev[i] = previous index in subset
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        int maxLen = 1;
        int maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        prev[i] = j;
                    }
                }
            }

            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }

        // Reconstruct the subset
        List<Integer> result = new ArrayList<>();
        int k = maxIndex;
        while (k >= 0) {
            result.add(nums[k]);
            k = prev[k];
        }

        Collections.reverse(result);
        return result;
    }
}
