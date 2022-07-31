class Solution {

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> ans = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < words2.length; i++) {
            HashMap<Character, Integer> map1 = new HashMap<>();

            for (int j = 0; j < words2[i].length(); j++) {
                char c = words2[i].charAt(j);
                map1.put(c, map1.getOrDefault(c, 0) + 1);
            }
            for (Character c : map1.keySet()) {
                if (map.containsKey(c)) {
                    int x = Math.max(map1.get(c), map.get(c));
                    map.put(c, x);
                } else map.put(c, map1.get(c));
            }
        }

        for (int i = 0; i < words1.length; i++) {
            HashMap<Character, Integer> map2 = new HashMap<>();

            for (int j = 0; j < words1[i].length(); j++) {
                char c = words1[i].charAt(j);
                map2.put(c, map2.getOrDefault(c, 0) + 1);
            }

            boolean flag = true;
            for (Character c : map.keySet()) {
                if (!map2.containsKey(c)) {
                    flag = false;
                    break;
                } else if (map2.get(c) < map.get(c)) {
                    flag = false;
                    break;
                }
            }
            if (flag) ans.add(words1[i]);
        }

        return ans;
    }
}
