import java.util.*;

class Solution {
    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int num : nums) {
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }

        int n = nums.size();
        int dominant = -1;

        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            map2.put(num, map2.getOrDefault(num, 0) + 1);
            map1.put(num, map1.getOrDefault(num, 0) - 1);

            if (map1.get(num) <= 0) {
                map1.remove(num);
            }

            if (map2.get(num) > (i+1) / 2 && map1.getOrDefault(num, 0) > (n - i - 1) / 2) {
                return i;
            }
        }

        return -1;
    }
}
