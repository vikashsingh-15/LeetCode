class Solution {
    public int minimumLength(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int deleteCount = 0;

        for (Character key : map.keySet()) {
            int freq = map.get(key);

            // If the frequency is odd, reduce it by 1 to make it even
            if (freq % 2 != 0) {
                deleteCount += freq - 1;
            } else {
                deleteCount += freq - 2;
            }
        }

        return s.length() - deleteCount;
    }
}
