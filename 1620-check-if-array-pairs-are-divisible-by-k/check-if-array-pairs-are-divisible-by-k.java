import java.util.HashMap;

class Solution {
    public boolean canArrange(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < arr.length; i++) {
            int rem = (arr[i] % k + k) % k;
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        for (int val : arr) {
            int rem = (val % k + k) % k;

            if (rem == 0) {
                if (map.get(rem) % 2 != 0) {
                    return false;
                }
            } else if (2 * rem == k) {
                if (map.get(rem) % 2 != 0) {
                    return false;
                }
            } else {
                int complementFreq = map.getOrDefault(k - rem, 0);
                if (map.get(rem) != complementFreq) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
   
