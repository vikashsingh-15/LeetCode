class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans = 1;

        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int prev = nums[i];

            for (int j = i+1; j < nums.length; j++) {
                if ((prev & nums[j]) == 0) {
                    prev |= nums[j];
                    count++;
                    ans = Math.max(ans, count);
                } else {
                    break;
                }
            }
        }

        return ans;
    }
}

////way 2
// class Solution {
//     public int longestNiceSubarray(int[] nums) {
//         int bitsSoFar = 0;
//         int apoint = 0;
//         int maxLength = 0;

//         for (int bpoint = 0; bpoint < nums.length; bpoint++) {
//             while ((bitsSoFar & nums[bpoint]) != 0) {
//                 bitsSoFar ^= nums[apoint];
//                 apoint++;
//             }

//             bitsSoFar |= nums[bpoint];
//             maxLength = Math.max(maxLength, bpoint - apoint + 1);
//         }

//         return maxLength;
//     }
// }
