// class Solution {
//     public long getDescentPeriods(int[] prices) {
//         long result = 1;   
//         long streak = 1;  

//         for (int i = 1; i < prices.length; i++) {
//             if (prices[i] == prices[i - 1] - 1) {
//                 streak++;          
//             } else {
//                 streak = 1;        
//             }
//             result += streak;  
//         }

//         return result;
//     }
// }

////way 2-- TLE
// class Solution {
//     public long getDescentPeriods(int[] prices) {
//         long count = 0;

//         for (int i = 0; i < prices.length; i++) {
//             count++; 

//             for (int j = i + 1; j < prices.length; j++) {
//                 if (prices[j] == prices[j - 1] - 1) {
//                     count++; 
//                 } else {
//                     break; 
//                 }
//             }
//         }

//         return count;
//     }
// }

class Solution {
    public long getDescentPeriods(int[] prices) {
        long[] memo = new long[prices.length];
        long result = 0;

        for (int i = 0; i < prices.length; i++) {
            result += dfs(prices, i, memo);
        }

        return result;
    }

    private long dfs(int[] prices, int i, long[] memo) {
        // Base case
        if (i == 0) {
            return memo[i] = 1;
        }

        // Already computed
        if (memo[i] != 0) {
            return memo[i];
        }

        // Recursive relation
        if (prices[i] == prices[i - 1] - 1) {
            memo[i] = dfs(prices, i - 1, memo) + 1;
        } else {
            memo[i] = 1;
        }

        return memo[i];
    }
}
