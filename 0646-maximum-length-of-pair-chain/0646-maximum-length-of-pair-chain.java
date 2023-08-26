class Solution {
    public int findLongestChain(int[][] pairs) {
        if (pairs.length <= 1) {
            return 1;
        }
        Arrays.sort(pairs, Comparator.comparingInt((int[] row) -> row[1]));

        int nonOverlappingCount = 0;
        int prevEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] <= prevEnd) {
                nonOverlappingCount++;
                // prevEnd = intervals[i][1];
            }else{
                prevEnd=pairs[i][1];
            }
        }

        return pairs.length - (nonOverlappingCount);
    }
}