class Solution {

    public List<List<Integer>> threeSum(int[] arr) {
        if (arr.length < 3) {
            List<List<Integer>> list = new ArrayList<>();
            return list;
        } else {
            int target = 0;
            Map<Integer, Integer> map = new HashMap<>();
            HashSet<List<Integer>> set = new HashSet<>();
            for (int i = 0; i < arr.length; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            }

            for (int i = 0; i < arr.length - 1; i++) {
                map.put(arr[i], map.getOrDefault(arr[i], 0) - 1);

                for (int j = i + 1; j < arr.length; j++) {
                    map.put(arr[j], map.getOrDefault(arr[j], 0) - 1);
                    int sum = arr[i] + arr[j];
                    if (map.containsKey(target - sum) && map.get(target - sum) > 0) {
                        List<Integer> list = new ArrayList<>();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(target - sum);
                        Collections.sort(list);
                        set.add(list);
                    }
                    map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
                }
            }
            if (set.size() > 0) {
                return new ArrayList(set);
            } else {
                List<List<Integer>> list = new ArrayList<>();
                return list;
            }
        }
    }
}
