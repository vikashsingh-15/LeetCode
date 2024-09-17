class Solution {

    public int findMinDifference(List<String> timePoints) {
        int[] minutes = new int[timePoints.size()];
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0, time.indexOf(":")));
            int m = Integer.parseInt(time.substring(time.indexOf(":")+1));
            minutes[i] = h * 60 + m;
        }

        Arrays.sort(minutes);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < minutes.length - 1; i++) {
            ans = Math.min(ans, minutes[i + 1] - minutes[i]);
        }
        int lastDiff=24 * 60 - minutes[minutes.length - 1] + minutes[0];//difference between last and first element

        return Math.min(ans,lastDiff);
    }
}