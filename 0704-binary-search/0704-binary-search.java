class Solution {
    public int search(int[] arr, int x) {
          int low=0;
        int high=arr.length-1;
        // int mid=(low + high)/2;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == x) {
                return mid;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}