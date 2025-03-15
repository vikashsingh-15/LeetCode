//// TLE
// class Solution {
//  int ans = 0;
//     public int change(int amount, int[] coins) {
//         helper(amount, coins, 0);
//         return ans;
//     }
//     public void helper(int amount, int[] coins, int index) {
//         if (amount == 0) {
//             ans++;
//             return;
//         }

//         if (amount < 0 || index >= coins.length) {
//             return;
//         }
//         helper(amount - coins[index], coins, index); 
//         helper(amount, coins, index + 1);  
//     }
// }

////way 2 
// class Solution {
//     int ans = 0;
//     HashMap<String, Integer> map = new HashMap<>();

//     public int change(int amount, int[] coins) {
//         helper(amount, coins, 0);
//         return ans;
//     }

//     public void helper(int amount, int[] coins, int index) {
//         if (amount == 0) {
//             ans++;
//             return;
//         }

//         if (amount < 0 || index >= coins.length) {
//             return;
//         }

//         String key = amount + "," + index;
//         if (map.containsKey(key)) {
//             ans += map.get(key); // Use previously computed result
//             return;
//         }

//         int before = ans;
//         helper(amount - coins[index], coins, index);
//         helper(amount, coins, index + 1);
//         map.put(key, ans - before);
//     }
// }

////way 3

import java.util.*;

class Solution {
    HashMap<String, Integer> map = new HashMap<>();

    public int change(int amount, int[] coins) {
        return helper(amount, coins, 0);
    }

    public int helper(int amount, int[] coins, int index) {
        if (amount == 0) return 1;
        if (amount < 0 || index >= coins.length) return 0;

        String key = amount + "," + index;
        if (map.containsKey(key)) return map.get(key);

        int take = helper(amount - coins[index], coins, index);
        int skip = helper(amount, coins, index + 1);

        map.put(key, take + skip);
        return take + skip;
    }
}
