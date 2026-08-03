// class Solution {
//     public String stoneGameIII(int[] stoneValue) {

//         int n = stoneValue.length;
//         int[] dp = new int[n + 3];

//         for (int i = n - 1; i >= 0; i--) {

//             int sum = 0;
//             dp[i] = Integer.MIN_VALUE;

//             // Take 1, 2, or 3 stones
//             for (int j = 0; j < 3 && i + j < n; j++) {

//                 sum += stoneValue[i + j];

//                 dp[i] = Math.max(
//                     dp[i],
//                     sum - dp[i + j + 1]
//                 );
//             }
//         }

//         if (dp[0] > 0) {
//             return "Alice";
//         }

//         if (dp[0] < 0) {
//             return "Bob";
//         }

//         return "Tie";
//     }
// }

////way 2 TLE

// class Solution {

//     public String stoneGameIII(int[] stoneValue) {

//         int result = solve(stoneValue, 0);

//         if (result > 0) {
//             return "Alice";
//         } else if (result < 0) {
//             return "Bob";
//         } else {
//             return "Tie";
//         }
//     }

//     public int solve(int[] arr, int i) {

//         // No stones remaining
//         if (i >= arr.length) {
//             return 0;
//         }

//         // Take 1 stone
//         int chooseOne = arr[i] - solve(arr, i + 1);

//         // Initially invalid
//         int chooseTwo = Integer.MIN_VALUE;
//         int chooseThree = Integer.MIN_VALUE;

//         // Take 2 stones
//         if (i + 1 < arr.length) {
//             chooseTwo =
//                     arr[i]
//                     + arr[i + 1]
//                     - solve(arr, i + 2);
//         }

//         // Take 3 stones
//         if (i + 2 < arr.length) {
//             chooseThree =
//                     arr[i]
//                     + arr[i + 1]
//                     + arr[i + 2]
//                     - solve(arr, i + 3);
//         }

//         return Math.max(
//                 chooseOne,
//                 Math.max(chooseTwo, chooseThree)
//         );
//     }
// }


////way 3

class Solution {

    public String stoneGameIII(int[] stoneValue) {

        Integer[] dp = new Integer[stoneValue.length];

        int result = solve(stoneValue, 0, dp);

        if (result > 0) {
            return "Alice";
        } else if (result < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    public int solve(int[] arr, int i, Integer[] dp) {

        // No stones left
        if (i >= arr.length) {
            return 0;
        }

        // Already calculated
        if (dp[i] != null) {
            return dp[i];
        }

        // Take 1 stone
        int chooseOne = arr[i] - solve(arr, i + 1, dp);

        int chooseTwo = Integer.MIN_VALUE;
        int chooseThree = Integer.MIN_VALUE;

        // Take 2 stones
        if (i + 1 < arr.length) {
            chooseTwo =
                    arr[i]
                    + arr[i + 1]
                    - solve(arr, i + 2, dp);
        }

        // Take 3 stones
        if (i + 2 < arr.length) {
            chooseThree =
                    arr[i]
                    + arr[i + 1]
                    + arr[i + 2]
                    - solve(arr, i + 3, dp);
        }

        dp[i] = Math.max(
                chooseOne,
                Math.max(chooseTwo, chooseThree)
        );

        return dp[i];
    }
}