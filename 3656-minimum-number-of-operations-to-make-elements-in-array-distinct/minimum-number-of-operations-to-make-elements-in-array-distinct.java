// class Solution {

//     public int minimumOperations(int[] nums) {
//         int ans = 0;
//         for (int i = 0; i < nums.length; i += 3, ans++) {
//             if (checkUnique(nums, i)) {
//                 return ans;
//             }
//         }
//         return ans;
//     }

//     private boolean checkUnique(int[] nums, int start) {
//         HashSet<Integer> cnt = new HashSet<>();
//         for (int i = start; i < nums.length; i++) {
//             if (cnt.contains(nums[i])) {
//                 return false;
//             }
//             cnt.add(nums[i]);
//         }
//         return true;
//     }
// }

////way 2
import java.util.*;

class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;

        for (int i = 0; i <= nums.length; i += 3) {
            HashSet<Integer> set = new HashSet<>();
            boolean hasDuplicate = false;

            for (int j = i; j < nums.length; j++) {
                if (set.contains(nums[j])) {
                    hasDuplicate = true;
                    break;
                }else{
                    set.add(nums[j]);
                }
            }

            if (hasDuplicate) {
                ans++;
            }else{
                return ans;
            }
        }

        return ans;
    }
}
