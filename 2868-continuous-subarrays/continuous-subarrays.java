// class Solution {
//     public long continuousSubarrays(int[] arr) {

//         int max=Integer.MIN_VALUE;
//         int min=Integer.MAX_VALUE;

//         int  left=0;
//         int right=0;
//         long windowLen=0,ans=0;

//         min=max=arr[0];

//         for( right=0; right <arr.length;right++){
//             max=Math.max(max,arr[right]);
//             min=Math.min(min,arr[right]);

//             if(max-min <2){
//                 ans+=(right-left+1);
//             }else{
//                 while(max-min>2){
//                     if(arr[left]==min || arr[left]==max){
//                         min = arr[left + 1];
//                         max=arr[left+1];
//                         for (int k = left + 1; k <= right; k++) {
//                             max = Math.max(max, arr[k]);
//                             min = Math.min(min, arr[k]);
//                         }

//                     }
//                     left++;
//                 }
//                 ans+=(right-left+1);

//             }

//         }


//        return ans; 
//     }
// }

//way  2

// class Solution {
//     public long continuousSubarrays(int[] arr) {

//         int max=Integer.MIN_VALUE;
//         int min=Integer.MAX_VALUE;

//         int  left=0;
//         int right=0;
//         long windowLen=0,ans=0;

//         min=max=arr[0];

//         for( right=0; right <arr.length;right++){
//             max=Math.max(max,arr[right]);
//             min=Math.min(min,arr[right]);
//                 while(max-min>2){
//                     if(arr[left]==min || arr[left]==max){
//                         min = arr[left + 1];
//                         max=arr[left+1];
//                         for (int k = left + 1; k <= right; k++) {
//                             max = Math.max(max, arr[k]);
//                             min = Math.min(min, arr[k]);
//                         }

//                     }
//                     left++;
//                 }
//                 ans+=(right-left+1);
//             }
//        return ans; 
//     }
// }

//way3

// class Solution {

//     public long continuousSubarrays(int[] nums) {
//         TreeMap<Integer, Integer> freq = new TreeMap<>();
//         int left = 0, right = 0;
//         int n = nums.length;
//         long count = 0; // Total count of valid subarrays

//         while (right < n) {
//             freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);

//             while (freq.lastEntry().getKey() - freq.firstEntry().getKey() > 2) {
//                 freq.put(nums[left], freq.get(nums[left]) - 1);
//                 if (freq.get(nums[left]) == 0) {
//                     freq.remove(nums[left]);
//                 }
//                 left++;
//             }

//             // Add count of all valid subarrays ending at right
//             count += right - left + 1;
//             right++;
//         }

//         return count;
//     }
// }

////way 4

// class Solution {

//     public long continuousSubarrays(int[] nums) {
//         int right = 0, left = 0;
//         int curMin, curMax;
//         long windowLen = 0, total = 0;

//         // Initialize window with first element
//         curMin = curMax = nums[right];

//         for (right = 0; right < nums.length; right++) {
//             // Update min and max for current window
//             curMin = Math.min(curMin, nums[right]);
//             curMax = Math.max(curMax, nums[right]);

//             // If window condition breaks (diff > 2)
//             if (curMax - curMin > 2) {
//                 // Add subarrays from previous valid window
//                 windowLen = right - left;
//                 total += ((windowLen * (windowLen + 1)) / 2);

//                 // Start new window at current position
//                 left = right;
//                 curMin = curMax = nums[right];

//                 // Expand left boundary while maintaining condition
//                 while (
//                     left > 0 && Math.abs(nums[right] - nums[left - 1]) <= 2
//                 ) {
//                     left--;
//                     curMin = Math.min(curMin, nums[left]);
//                     curMax = Math.max(curMax, nums[left]);
//                 }

//                 // Remove overcounted subarrays if left boundary expanded
//                 if (left < right) {
//                     windowLen = right - left;
//                     total -= ((windowLen * (windowLen + 1)) / 2);
//                 }
//             }
//         }

//         // Add subarrays from final window
//         windowLen = right - left;
//         total += ((windowLen * (windowLen + 1)) / 2);

//         return total;
//     }
// }

////way 5

import java.util.*;

public class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0;
        long count = 0;

        for (int right = 0; right < nums.length; right++) {
            // Add current element to map
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            // Shrink window from left if max - min > 2
            while (map.lastKey() - map.firstKey() > 2) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
        }

        return count;
    }
}
