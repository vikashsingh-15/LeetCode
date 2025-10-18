import java.util.*;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int x : nums) {
            int remainder = ((x % value) + value) % value;
            countMap.put(remainder, countMap.getOrDefault(remainder, 0) + 1);
        }

        int i = 0;
        while (true) {
            int remainder = i % value;
            int freq = countMap.getOrDefault(remainder, 0);
            if (freq == 0) {
                return i;
            }
            countMap.put(remainder, freq - 1);
            i++;
        }
    }
}
