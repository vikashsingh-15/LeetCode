// class Solution {
//         public boolean predictTheWinner(int[] nums) {
//         return canFirstPlayerWin(nums, 0, nums.length - 1)>=0;
//     }

//     private int canFirstPlayerWin(int[] nums, int start, int end) {
//         if (start == end) {
//             return nums[start];
//         }
//         int chooseStart = nums[start] - canFirstPlayerWin(nums, start + 1, end);
//         int chooseEnd = nums[end] - canFirstPlayerWin(nums, start, end - 1);
//         return Math.max(chooseStart, chooseEnd);
//     }

// }


class Solution {
    public boolean predictTheWinner(int[] nums) {

        int n = nums.length;

        int[][] dp = new int[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int i = 0,j=gap; j < n;j++, i++) {
               if(gap==0){
                   dp[i][i] = nums[i];
               }else{
                   int chooseFirst =nums[i]-dp[i+1][j];
                   int chooseLast =nums[j]-dp[i][j-1];
                   dp[i][j]=Math.max(chooseFirst,chooseLast);
                    // dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
               }

            }
        }
        return dp[0][n - 1] >= 0;

    }
}




//way 2

//wrong approach will fail for 1,567,1,1 this kind of testcase

// class Solution {

//     public boolean predictTheWinner(int[] nums) {
//         if(nums.length<=2){
//             return true;
//         }
//         int sumEven = 0;
//         int sumOdd = 0;

//         for (int i = 0; i < nums.length; i++) {
//             if (i % 2 == 0) {
//                 sumEven += nums[i];
//             } else {
//                 sumOdd += nums[i];
//             }
//         }

//         return sumEven >= sumOdd;
//     }
// }

