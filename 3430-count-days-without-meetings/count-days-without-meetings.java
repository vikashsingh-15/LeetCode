class Solution {
    public int countDays(int days, int[][] meetings) {
        if (meetings.length == 0) return days;
        
        int freeDay = 0;
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        freeDay += meetings[0][0] - 1;
        int prevEnd = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {
            if (meetings[i][0] > prevEnd + 1) {
                freeDay += meetings[i][0] - prevEnd - 1;
            }
            prevEnd = Math.max(prevEnd, meetings[i][1]);
        }

        freeDay += days - prevEnd;
        return freeDay;
    }
}