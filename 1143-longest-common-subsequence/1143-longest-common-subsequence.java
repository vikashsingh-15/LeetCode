class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        //way 1
        int dp[][]=new int [text1.length()+1][text2.length()+1];
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==text1.length() || j==text2.length()){
                    dp[i][j]=0;
                }
                else{
                    if(text1.charAt(i)==text2.charAt(j)){
                        dp[i][j]=dp[i+1][j+1]+1;
                    }else{
                        dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);
                    }
                }
            }
        }
        return dp[0][0];

       // //way 2

        // int m = text1.length();
        // int n = text2.length();
// /*
// Instead of using a matrix or 2 arrays, we can only use one array to store the previous values and use variables to store the currrent value in temp variable and than keep a track of previous value in prev varaible. After one iteration just update the prev to temp and temp to current value.
// */
//         // //int[][] dp = new int[m+1][n+1];
        // // int[] prev = new int[m+1];
        // int[] curr = new int[n + 1];
        // for (int i = 1; i <= m; i++) {
        //     int prev = curr[0];
        //     for (int j = 1; j <= n; j++) {     
        //         int temp = curr[j];
        //          // System.out.println("for i ans j = "+i+" "+j+" temp is = "+temp);
        //         if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
        //             curr[j] = 1 + prev;
        //         } else {
        //             curr[j] = Math.max(curr[j], curr[j - 1]);
        //         }
        //         prev = temp;
        //         // System.out.println("for i ans j = "+i+" "+j+" prev is = "+prev);
        //     }
        // }
        // return curr[n];
        
        
        
        
        
        
        
        //way 3
        //  int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        // for (int i = 1; i <= s1.length(); i++) {
        //     for (int j = 1; j <= s2.length(); j++) {
        //         if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
        //         else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        //     }
        // }
        // return dp[s1.length()][s2.length()];
    }
}
