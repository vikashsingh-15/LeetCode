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
class Solution {
    int ans = 0;
    HashMap<String, Integer> map = new HashMap<>();

    public int change(int amount, int[] coins) {
        helper(amount, coins, 0);
        return ans;
    }

    public void helper(int amount, int[] coins, int index) {
        if (amount == 0) {
            ans++;
            return;
        }

        if (amount < 0 || index >= coins.length) {
            return;
        }

        String key = amount + "," + index;
        if (map.containsKey(key)) {
            ans += map.get(key); // Use previously computed result
            return;
        }

        int before = ans;
        helper(amount - coins[index], coins, index);
        helper(amount, coins, index + 1);
        map.put(key, ans - before);
    }
}