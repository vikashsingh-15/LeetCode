class Solution {

    public int longestPalindromeSubseq(String s) {
        //way 1
        int n = s.length();
        int[][] dp = new int[n][n];
        //move on gap i.e, diagonally
        for (int gap = 0; gap < n; gap++) {
            for (int j = gap, i = 0; j < n; i++, j++) {
                if (gap == 0) {
                    dp[i][j] = 1;
                } else if (gap == 1) {
                    dp[i][j] = s.charAt(i) == s.charAt(j) ? 2 : 1;
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                    }
                }
            }
        }
        return dp[0][n - 1];
        //way 2

        //         int n = s.length();
        //         int[][] dp = new int[n][n];
        //         // Base case
        //         for (int i = 0; i < n; i++) {
        //             dp[i][i] = 1;
        //         }

        //         for (int i = n - 1; i >= 0; i--) {
        //             for (int j = i + 1; j < n; j++) {
        //                 if (s.charAt(i) == s.charAt(j)) {
        //                     dp[i][j] = dp[i + 1][j - 1] + 2;
        //                 } else {
        //                     dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        //                 }
        //             }
        //         }

        //         return dp[0][n - 1];

        //way 3 ---BrutForce TLE
        // return longestPalindromeSubseqHelper(s, 0, s.length() - 1);
    }

    // private int longestPalindromeSubseqHelper(String s, int left, int right) {
    //     if (left > right) {
    //         return 0;
    //     }

    //     if (left == right) {
    //         return 1;
    //     }

    //     if (s.charAt(left) == s.charAt(right)) {
    //         return 2 + longestPalindromeSubseqHelper(s, left + 1, right - 1);
    //     } else {
    //         return Math.max(longestPalindromeSubseqHelper(s, left + 1, right), longestPalindromeSubseqHelper(s, left, right - 1));
    //     }
    // }
}
