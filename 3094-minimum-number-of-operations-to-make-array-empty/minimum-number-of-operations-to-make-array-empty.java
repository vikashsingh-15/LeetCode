class Solution {

    public int minOperations(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int t : frequencyMap.values()) {
            if (t == 1) {
                return -1;
            }

            count += t / 3;
            if (t % 3 != 0) {
                count++;
            }
        }

        return count;
    }
}
