class Solution {

    //     public int[] sortArray(int[] nums) {
    // // WAY 1
    //         //  int n = nums.length;
    //         // int max = nums[0];
    //         // int min = nums[0];
    //         // for (int i = 0; i < n; i++) {
    //         //     int num = nums[i];
    //         //     max = Math.max(max, num);
    //         //     min = Math.min(min, num);
    //         // }
    //         // int len = max - min;
    //         // int[] arr = new int[len + 1];
    //         // for (int i = 0; i < n; i++) {
    //         //     int num = nums[i];
    //         //     arr[num - min]++;
    //         // }
    //         // int index = 0;
    //         // for (int i = 0; i <= len; i++) {
    //         //     while (arr[i] > 0) {
    //         //         nums[index] = min;
    //         //         index++;
    //         //         arr[i]--;
    //         //     }
    //         //     min++;
    //         // }
    //         // return nums;

    // //WAY 2
    //         // PriorityQueue<Integer> pq = new PriorityQueue<>();
    //         // for (int i = 0; i < nums.length; i++) pq.add(nums[i]);
    //         // int idx = 0;
    //         // while (pq.size() > 0) {
    //         //     nums[idx] = pq.remove();
    //         //     idx++;
    //         // }
    //         // return nums;
    //     }

    public int[] sortArray(int[] nums) {
      mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] arr, int low, int high) {
        if (low == high) {
            return;
        }
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        mergeTwoArr(arr, low, mid, high);
    }

    private void mergeTwoArr(int[] a, int l, int m, int r) {
        int[] b = Arrays.copyOfRange(a, l, m + 1);
        int[] c = Arrays.copyOfRange(a, m + 1, r + 1);
        int i = 0, j = 0, k = l;
        while (i < b.length && j < c.length) {
            if (b[i] <= c[j]) {
                a[k++] = b[i++];
            } else {
                a[k++] = c[j++];
            }
        }
        while (i < b.length) {
            a[k++] = b[i++];
        }
        while (j < c.length) {
            a[k++] = c[j++];
        }
    }
}
