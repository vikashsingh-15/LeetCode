class Solution {

    public int findPairs(int[] arr, int target) {
        //         //way 1
        //         int apoint = 0;
        //         int bpoint = 1;
        //         int count = 0;
        //         Arrays.sort(arr);
        //         while (apoint <= bpoint && bpoint < arr.length) {
        //             int temp = arr[bpoint];
        //             while (bpoint < arr.length && arr[bpoint] == temp) {
        //                 bpoint++;
        //             }
        //             bpoint--;

        //             int diff = arr[bpoint] - arr[apoint];
        //             if (diff == target && apoint != bpoint) {
        //                 bpoint++;
        //                 count++;
        //             } else if (diff < target) {
        //                 bpoint++;
        //             } else {
        //                 apoint++;
        //             }
        //         }

        //         return count;

        //way 2

        Map<Integer, Integer> map = new HashMap();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int result = 0;
        for (int i : map.keySet()) {
            if (target > 0 && map.containsKey(i + target) || target == 0 && map.get(i) > 1) {
                result++;
                map.put(i + target, map.getOrDefault(i + target, 0) - 1);
            }
        }

        return result;
    }
}
