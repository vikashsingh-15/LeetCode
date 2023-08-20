import java.util.Arrays;
import java.util.Comparator;

// class Solution {
//     public int eraseOverlapIntervals(int[][] intervals) {
//       Arrays.sort(intervals, Comparator.comparingInt((int[] row) -> row[0]));
//         int prev = 0;
//         int count = 0;
        
//         for (int i = 1; i < intervals.length; i++) {
//             if (intervals[prev][1] > intervals[i][0]) {
//                 count++;
//             } else {
//                 prev = i;
//             }
//         }
        
//         return count;
//     }
// }

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
      if (intervals.length <= 1) {
            return 0;
        }

        // Sort intervals based on end times
        Arrays.sort(intervals, Comparator.comparingInt((int[] row) -> row[1]));

        int nonOverlappingCount = 1; // At least one interval will be non-overlapping
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= prevEnd) {
                nonOverlappingCount++;
                prevEnd = intervals[i][1];
            }
        }

        return intervals.length - nonOverlappingCount;
    }
}