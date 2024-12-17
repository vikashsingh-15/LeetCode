import java.util.*;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        TreeMap<Character, Integer> map = new TreeMap<>((a, b) -> b - a);
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        
        while (!map.isEmpty()) {
            char maxChar = map.firstKey();
            int count = map.get(maxChar);
            map.remove(maxChar);
        
            int take = Math.min(count, repeatLimit);
            
            for (int i = 0; i < take; i++) {
                result.append(maxChar);
            }

            count -= take;
            if (count > 0) {
                if (!map.isEmpty()) {
                    char nextChar = map.firstKey();
                    int nextCount = map.get(nextChar);
                    map.remove(nextChar);
                    result.append(nextChar);
                    if (nextCount > 1) {
                        map.put(nextChar, nextCount - 1);
                    }
                    map.put(maxChar, count);
                } else {
                    break;
                }
            }
        }
        
        return result.toString();
    }
}
