class Solution {
    public int minimumRecolors(String str, int k) {

        int left = 0;
        int numWhite = 0;
        int numRecol = Integer.MAX_VALUE;

        for (int right = 0; right < str.length(); right++) {
            if (str.charAt(right) == 'W') {
                numWhite++;
            }

            if (right - left + 1 == k) {
                numRecol = Math.min(numWhite, numRecol);
                if (str.charAt(left) == 'W') {
                    numWhite--;
                }
                left++;
            }

        }
        return numRecol;
    }
}