class Solution {

    public String reorganizeString(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        pq.addAll(freqMap.keySet());

        StringBuilder result = new StringBuilder();

        while (!pq.isEmpty()) {
            char first = pq.poll();
            if (result.length() == 0 || result.charAt(result.length() - 1) != first) {
                result.append(first);
                freqMap.put(first, freqMap.get(first) - 1);
                if (pq.isEmpty()) {
                    break;
                }
            }  
                char second = pq.poll();
                result.append(second);
                freqMap.put(second, freqMap.get(second) - 1);
                if (freqMap.get(first) > 0) {
                    pq.offer(first);
                }
                if (freqMap.get(second) > 0) {
                    pq.offer(second);
                }
        }

        if (result.length()==s.length()){
            return result.toString();
        }
        return "";
    }
}
