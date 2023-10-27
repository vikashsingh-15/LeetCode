class Solution {
    public String longestPalindrome(String str) {
        int n = str.length();
         int start=0;
        int end=0;
        boolean[][] dp = new boolean[n][n];
        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp[0].length; i++, j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    if (g == 0) {
                        dp[i][j] = true;
                    } else if (g == 1) {
                        dp[i][j] = true;
                    } else {
                        if (dp[i + 1][j - 1]) {
                            dp[i][j] = true;
                        }
                    }
                }
                if (dp[i][j]) {
                    // System.out.println(str.substring(i, j + 1));
                    start=i;
                    end=j;
                }
            }
        }
        return(str.substring(start, end + 1));
    }
}