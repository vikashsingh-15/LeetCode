//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            int k = sc.nextInt();
            Solution obj = new Solution();
            System.out.println(obj.longestkSubstr(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
         int n = s.length();
        if (n < k) {
            return -1;
        }

        Map<Character, Integer> charCount = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        int left = 0;

        for (int right = 0; right < n; right++) {
            char currChar = s.charAt(right);
            charCount.put(currChar, charCount.getOrDefault(currChar, 0) + 1);

            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            if (charCount.size() == k) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        return maxLength == Integer.MIN_VALUE ? -1 : maxLength;
    }
}