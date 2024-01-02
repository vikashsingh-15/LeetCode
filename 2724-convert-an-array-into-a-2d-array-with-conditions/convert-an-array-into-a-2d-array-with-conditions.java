class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> indexMap = new HashMap<>();

        int max = 0;
        for (int num : nums) {
            indexMap.put(num, indexMap.getOrDefault(num, 0) + 1);
            max = Math.max(max, indexMap.get(num));
        }
        for (int i = 0; i < max; i++) {
            result.add(new ArrayList<>());
        }

        for (Integer key : indexMap.keySet()) {
            int value = indexMap.get(key);
            while (value > 0) {
                result.get(value - 1).add(key);
                value--;
            }
        }

        return result;
    }
}