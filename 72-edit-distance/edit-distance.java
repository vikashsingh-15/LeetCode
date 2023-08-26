// class Solution {
//     public int minDistance(String word1, String word2) {
//               int m = word1.length();
//         int n = word2.length();
//         int[][] dp = new int [m+1][n+1];

//         for(int i=0 ; i<=m; i++)
//             dp[i][0] = i;
//         for(int i=0; i<=n; i++)
//             dp[0][i] = i;

//         for(int i=1; i<=m; i++){
//             for(int j=1; j<=n; j++){
//                 if(word1.charAt(i-1) == word2.charAt(j-1))
//                     dp[i][j] = dp[i-1][j-1];
//                 else
//                     dp[i][j] = 1 + Math.min(dp[i-1][j-1],
//                                             Math.min(dp[i-1][j],
//                                                      dp[i][j-1]));
//             }
//         }
//         return dp[m][n];
//     }
// }

//BruteForce ->TLE
// class Solution {

//     public int minDistance(String word1, String word2) {
//         return calculateDistance(word1, word2, 0, 0);
//     }

//     public int calculateDistance(String word1, String word2, int i, int j) {
//         if (i == word1.length()) {
//             return word2.length() - j;
//         }
//         if (j == word2.length()) {
//             return word1.length() - i;
//         }

//         if (word1.charAt(i) == word2.charAt(j)) {
//             return calculateDistance(word1, word2, i + 1, j + 1);
//         }

//         int insert = calculateDistance(word1, word2, i, j + 1) + 1;
//         int delete = calculateDistance(word1, word2, i + 1, j) + 1;
//         int replace = calculateDistance(word1, word2, i + 1, j + 1) + 1;

//         return Math.min(insert, Math.min(delete, replace));
//     }
// }
/*End of word1 reached: If we have processed all characters in word1 (reached the end of word1), it means that any remaining characters in word2 need to be inserted to match word1.

End of word2 reached: If we have processed all characters in word2 (reached the end of word2), it means that any remaining characters in word1 need to be deleted to match word2.  */

class Solution {

    public int minDistance(String word1, String word2) {
       Map<String, Integer> memo = new HashMap<>();
       return calculateDistance(word1, word2, 0, 0,memo);
    }

    public int calculateDistance(String word1, String word2, int i, int j,Map<String, Integer> memo) {
        String key = i + "," + j;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        if (i == word1.length()) {
            memo.put(key, word2.length() - j);
            return memo.get(key);
        }
        if (j == word2.length()) {
            memo.put(key, word1.length() - i);
            return memo.get(key);
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            int result = calculateDistance(word1, word2, i + 1, j + 1, memo);
            memo.put(key, result);
            return result;
        }

        int insert = calculateDistance(word1, word2, i, j + 1, memo) + 1;
        int delete = calculateDistance(word1, word2, i + 1, j, memo) + 1;
        int replace = calculateDistance(word1, word2, i + 1, j + 1, memo) + 1;

        int result = Math.min(insert, Math.min(delete, replace));
        memo.put(key, result);
        return result;

    }
}