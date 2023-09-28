class Solution {
    public int numSubseq(int[] nums, int target) {
         int MOD = 1000000007;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int result = 0;
        
        int[] powerOfTwo = new int[nums.length];
        powerOfTwo[0] = 1;
        
        for (int i = 1; i < nums.length; i++) {
            powerOfTwo[i] = (powerOfTwo[i - 1] * 2) % MOD;
        }
        
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                result = (result + powerOfTwo[right - left]) % MOD;
                left++;
            }
        }
        
        return result;
    }
}


//// way 2 -> TLE-Memory Limit Exceeded

// class Solution {
//     public int numSubseq(int[] nums, int target) {
//        Arrays.sort(nums);
//         List<List<Integer>> subsequences = generateSubsequences(nums);
//         int count = 0;
//         int MOD = 1000000007;

//         for (List<Integer> subsequence : subsequences) {
//             if (!subsequence.isEmpty()) {
//                 int sum = subsequence.get(0) + subsequence.get(subsequence.size() - 1);
//                 if (sum <= target) {
//                     count = (count + 1) % MOD;
//                 }
//             }
//         }

//         return count;
//     }
//      public  List<List<Integer>> generateSubsequences(int[] nums) {
//         List<List<Integer>> result = new ArrayList<>();
//         generate(nums, 0, new ArrayList<>(), result);
//         return result;
//     }

//     private  void generate(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
//         if (index == nums.length) {
//             result.add(new ArrayList<>(current));
//             return;
//         }

//         current.add(nums[index]);
//         generate(nums, index + 1, current, result);

//         current.remove(current.size() - 1);
//         generate(nums, index + 1, current, result);
//     }
// }