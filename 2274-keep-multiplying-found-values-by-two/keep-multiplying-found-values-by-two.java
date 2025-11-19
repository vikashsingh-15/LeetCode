// class Solution {

//     public int findFinalValue(int[] nums, int original) {
//         Arrays.sort(nums);
//         for (int num : nums) {
//             if (original == num) {
//                 original *= 2;
//             }
//         }
//         return original;
//     }
// }

//way 2

class Solution {

    public int findFinalValue(int[] nums, int original) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (set.contains(original)) {
            original *= 2;
        }
        return original;
    }
}