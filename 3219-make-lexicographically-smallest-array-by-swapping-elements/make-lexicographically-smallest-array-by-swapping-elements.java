// ////TLE
// class Solution {
//     public int[] lexicographicallySmallestArray(int[] nums, int limit) {
//          int n = nums.length;
//         boolean swapped; 

//         do {
//             swapped = false; 
//             for (int i = 0; i < n; i++) { 
//                 for (int j = i + 1; j < n; j++) { 
//                     if (nums[j] < nums[i] && Math.abs(nums[j] - nums[i]) <= limit) {
//                         int temp = nums[i];
//                         nums[i] = nums[j];
//                         nums[j] = temp;
//                         swapped = true; // Mark that a swap occurred
//                     }
//                 }
//             }
//         } while (swapped); 

//         return nums;
//     }
// }

//// way 2

class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
         int n = nums.length;
        int[] sortArr = Arrays.copyOf(nums, n);
        Arrays.sort(sortArr);

        Map<Integer, Integer> map = new HashMap<>();
        List<Deque<Integer>> groups = new ArrayList<>();
        
        int group = 0;
        Deque<Integer> temp = new LinkedList<>();
        temp.add(sortArr[0]);
        map.put(sortArr[0], group);

        for (int i = 1; i < n; i++) {
            if (Math.abs(sortArr[i] - sortArr[i - 1]) <= limit) {
                map.put(sortArr[i], group);
                temp.add(sortArr[i]);
            } else {
                groups.add(new LinkedList<>(temp));
                temp.clear();
                group++;
                temp.add(sortArr[i]);
                map.put(sortArr[i], group);
            }
        }
        groups.add(new LinkedList<>(temp));

        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int g = map.get(x);
            int y = groups.get(g).removeFirst();
            nums[i] = y;
        }

        return nums;
       
    }
}