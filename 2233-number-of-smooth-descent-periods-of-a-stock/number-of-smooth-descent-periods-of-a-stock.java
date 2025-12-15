class Solution {
    public long getDescentPeriods(int[] prices) {
        long result = 1;   
        long streak = 1;  

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                streak++;          
            } else {
                streak = 1;        
            }
            result += streak;  
        }

        return result;
    }
}

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
