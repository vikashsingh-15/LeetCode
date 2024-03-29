//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends




//User function Template for Java

// class Solution
// {
//     public int LongestRepeatingSubsequence(String str)
//     {
//         int n = str.length();
//         int[][] dp = new int[n + 1][n + 1];

//         // Fill the dp array
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= n; j++) {
//                 // If characters match and indices are different
//                 if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
//                     dp[i][j] = 1 + dp[i - 1][j - 1];
//                 } else {
//                     dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
//                 }
//             }
//         }

//         return dp[n][n];
//     }
// }


class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        // Fill the dp array
        for (int i = n-1; i >=0; i--) {
            for (int j=n-1; j >=0; j--) {
                // If characters match and indices are different
                if (str.charAt(i) == str.charAt(j) && i != j) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][0];
    }
}