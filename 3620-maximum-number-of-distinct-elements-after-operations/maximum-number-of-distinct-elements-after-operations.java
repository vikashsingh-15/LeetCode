// Wrong Approach Fails for [1,1,1,2,2,2,4,4,4,4] and k=2

// class Solution {
//     public int maxDistinctElements(int[] nums, int k) {
//         Arrays.sort(nums);
//         int cnt = 0;
//         int same = 1; 

//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] == nums[i - 1]) {
//                 same++;
//             } else {
//                 if (same > 2*k + 1) {
//                     cnt += 2*k + 1;
//                 } else {
//                     cnt += same;
//                 }
//                 same = 1;
//             }
//         }
//         if (same > 2* k + 1) {
//             cnt += 2 *k + 1;
//         } else {
//             cnt += same;
//         }

//         return cnt;
//     }
// }

import java.util.*;

class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        long prev = Long.MIN_VALUE; 

        for (int num : nums) {
            int minValue=num-k;
            if(prev<minValue){
                cnt++;
                prev=minValue;
            }else if(prev<num+k){
                cnt++;
                prev=prev+1;
            }
        }

        return cnt;
    }
}
