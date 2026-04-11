import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        // Step 1: Store indices of each value
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        
        int minDist = Integer.MAX_VALUE;
        
        // Step 2: Process each group
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue;
            
            // Step 3: Check consecutive triplets
            for (int i = 0; i <= list.size() - 3; i++) {
                int first = list.get(i);
                int third = list.get(i + 2);
                
                int dist = 2 * (third - first);
                minDist = Math.min(minDist, dist);
            }
        }
        
        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}