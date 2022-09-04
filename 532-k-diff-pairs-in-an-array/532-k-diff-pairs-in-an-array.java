class Solution {

    public int findPairs(int[] arr, int target) {
        int apoint = 0;
        int bpoint = 1;
        int count = 0;

        Arrays.sort(arr);

        while (apoint <= bpoint && bpoint < arr.length) {
            int temp = arr[bpoint];
            while (bpoint < arr.length && arr[bpoint] == temp) {
                bpoint++;
            }
            bpoint--;

            int diff = arr[bpoint] - arr[apoint];
            if (diff == target && apoint != bpoint) {
                bpoint++;
                count++;
            } else if (diff < target) {
                bpoint++;
            } else {
                apoint++;
            }
        }
        
        return count;
    }
}
