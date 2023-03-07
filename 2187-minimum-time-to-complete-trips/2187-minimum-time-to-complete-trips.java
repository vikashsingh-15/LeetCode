class Solution {
    public long minimumTime(int[] time, int totalTrips) {
          
        long start = 0;
        long end = 100_000_000_000_000L;
        
        while (start < end) {
            long mid = start + (end - start) / 2;
            long trip = 0;
            for (int i = 0; i < time.length; i++) {
                trip += mid / time[i];
            }
            if (trip < totalTrips) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return start;
    }
}