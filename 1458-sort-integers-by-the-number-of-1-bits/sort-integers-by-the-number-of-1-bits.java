import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {

        Map<Integer, List<Integer>> map = new TreeMap<>();

        for (int num : arr) {
            int bits = Integer.bitCount(num);

            map.putIfAbsent(bits, new ArrayList<>());
            map.get(bits).add(num);
        }

        int index = 0;

        for (List<Integer> list : map.values()) {
            Collections.sort(list); 
            for (int num : list) {
                arr[index++] = num;
            }
        }

        return arr;
    }
}