//TLE
// class Solution {
//     public int maxTwoEvents(int[][] events) {
//         int n=events.length;
//         int max=-1;
//         for(int i=0;i<n;i++){
//             for(int j=i+1;j<n;j++){
//                 if(!overlap(events[i],events[j])){
//                     max=Math.max(max,events[i][2]+events[j][2]);
//                 }
//             }
//             max = Math.max(max, events[i][2]);
//         }
//         return max;
//     }

//     public boolean overlap(int []event1,int [] event2){
//         return event1[1] >= event2[0] && event2[1] >= event1[0];
//     }
// }

// ////TLE
// class Solution {

//    public int maxTwoEvents(int[][] events) {
//         // Sort events by their start time
//         Arrays.sort(events, (a, b) -> a[0] - b[0]);
//         return findEvents(events, 0, 0);
//     }

//     int findEvents(int[][] events, int idx, int count) {
//         // Base case: if we have chosen 2 events or processed all events
//         if (count == 2 || idx >= events.length) return 0;

//         // Find the next non-overlapping event
//         int nextIndex = binarySearch(events, idx, events[idx][1]);

//         // Calculate the value if we take the current event
//         int take = events[idx][2] + findEvents(events, nextIndex, count + 1);

//         // Calculate the value if we skip the current event
//         int notTake = findEvents(events, idx + 1, count);

//         // Return the maximum of both choices
//         return Math.max(take, notTake);
//     }

//     int binarySearch(int[][] events, int idx, int endTime) {
//         int low = idx + 1, high = events.length - 1;
//         int result = events.length; // Default to no valid event
//         while (low <= high) {
//             int mid = low + (high - low) / 2;
//             if (events[mid][0] > endTime) {
//                 result = mid; // Valid event found, try earlier
//                 high = mid - 1;
//             } else {
//                 low = mid + 1; // Look for later events
//             }
//         }
//         return result;
//     }

// }



////wway 3 TLE
// class Solution {
//     int maxSum = 0;

//     public int maxTwoEvents(int[][] events) {
//         // Sort events by start time
//         Arrays.sort(events, (a, b) -> a[0] - b[0]);

//         // Start backtracking from the first event
//         backtrack(events, 0, 0, 0);
//         return maxSum;
//     }

//     private void backtrack(int[][] events, int idx, int count, int currentSum) {
//         // Base case: if we have selected 2 events or exhausted all events
//         if (count == 2 || idx >= events.length) {
//             maxSum = Math.max(maxSum, currentSum);
//             return;
//         }

//         // Skip the current event and move to the next
//         backtrack(events, idx + 1, count, currentSum);

//         // Include the current event and find the next non-overlapping event
//         int nextIdx = findNextNonOverlapping(events, idx);
//         backtrack(events, nextIdx, count + 1, currentSum + events[idx][2]);
//     }

//     private int findNextNonOverlapping(int[][] events, int idx) {
//         // Find the next event that starts after the current event's end time
//         int endTime = events[idx][1];
//         for (int i = idx + 1; i < events.length; i++) {
//             if (events[i][0] > endTime) {
//                 return i;
//             }
//         }
//         return events.length; // No valid event found
//     }
// }


//way 4

class Solution {

    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int[][] dp = new int[events.length][3];
        for (int[] d : dp) Arrays.fill(d, -1);
        return findEvents(events, 0, 0, dp);
    }

    // Recursive function to find the greatest sum for the pairs.
    int findEvents(int[][] events, int idx, int cnt, int[][] dp) {
        if (cnt == 2 || idx >= events.length) return 0;
        if (dp[idx][cnt] == -1) {
            int end = events[idx][1];
            int lo = idx + 1, hi = events.length - 1;
            while (lo < hi) {
                int mid = lo + ((hi - lo) >> 1);
                if (events[mid][0] > end) hi = mid;
                else lo = mid + 1;
            }
            int include =
                events[idx][2] +
                (lo < events.length && events[lo][0] > end
                        ? findEvents(events, lo, cnt + 1, dp)
                        : 0);
            int exclude = findEvents(events, idx + 1, cnt, dp);
            dp[idx][cnt] = Math.max(include, exclude);
        }
        return dp[idx][cnt];
    }
}