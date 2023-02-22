class Solution {

    public int shipWithinDays(int[] weights, int days) {
        int min = 0;
        int max = 0;
        for (int i = 0; i < weights.length; i++) {
            min = Math.max(min, weights[i]);
            max += weights[i];
        }
        int retval = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            int c = check(weights, mid);
            if (c > days) {
                min = mid + 1;
            } else {
                retval = mid;
                max = mid - 1;
            }
        }

        return retval;
    }

    public int check(int[] arr, int mid) {
        int day = 1;
        int w = 0;
        for (int i = 0; i < arr.length; i++) {
            w += arr[i];
            if (w > mid) {
                day++;
                w = arr[i];
            }
        }
        return day;
    }
}
