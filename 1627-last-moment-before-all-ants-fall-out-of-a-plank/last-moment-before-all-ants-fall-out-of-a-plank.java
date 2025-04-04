class Solution {
    public int getLastMoment(int n, int[] left, int[] right) {
        int maxTimeToLeft = 0;
        int maxTimeToRight = 0;

        for (int antPosition : left) {
            maxTimeToLeft = Math.max(maxTimeToLeft, antPosition);
        }
        // System.out.println("max Time left = "+maxTimeToLeft);

        for (int antPosition : right) {
            maxTimeToRight = Math.max(maxTimeToRight, n - antPosition);
        }
        //  System.out.println("max Time right = "+maxTimeToRight);

        return Math.max(maxTimeToLeft, maxTimeToRight);
    }
}