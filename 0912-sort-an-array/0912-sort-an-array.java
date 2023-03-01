class Solution {

    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length);
        return nums;
    }

    private void mergeSort(int[] a, int l, int r) {
        if (l == r - 1) return;
        int m = (l + r) / 2;
        mergeSort(a, l, m);
        mergeSort(a, m, r);
        merge(a, l, m, r);
    }

    private void merge(int[] a, int l, int m, int r) {
        int[] b = Arrays.copyOfRange(a, l, m);
        int j = 0, k = m;
        for (int i = l; i < r; i++) {
            if (j < b.length && k < r) a[i] = b[j] < a[k] ? b[j++] : a[k++]; 
            else a[i] = k < r ? a[k++] : b[j++];
        }
    }
    //         public int[] sortArray(int[] nums) {
    //         int[] sa=mergeSort(nums, 0, nums.length-1);
    //         return sa;
    //     }

    //     public int[] mergeSort(int[] a, int low, int high) {
    //         if (low == high) {
    //             int[] b = new int[1];
    //             b[0] = a[low];
    //             return b;
    //         }
    //         int mid = (low + high) / 2;
    //         int[] firstSortedHalf = mergeSort(a, low, mid);
    //         int[] secondSortedHalf = mergeSort(a, mid + 1, high);
    //         int[] sortedArray = mergeTwoSortedArray(firstSortedHalf, secondSortedHalf);
    //         return sortedArray;
    //     }

    //     public static int[] mergeTwoSortedArray(int[] a, int[] b) {
    //         int i = 0, j = 0, k = 0;
    //         int[] c = new int[a.length + b.length];
    //         while (i < a.length && j < b.length) {
    //             if (a[i] <= b[j]) {
    //                 c[k] = a[i];
    //                 i++;
    //                 k++;
    //             } else {
    //                 c[k] = b[j];
    //                 j++;
    //                 k++;
    //             }
    //         }
    //         while (i < a.length) {
    //             c[k] = a[i];
    //             k++;
    //             i++;
    //         }
    //         while (j < b.length) {
    //             c[k] = b[j];
    //             k++;
    //             j++;
    //         }
    //         return c;
    //     }
}
