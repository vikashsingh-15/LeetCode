class Solution {

    public int maxProduct(int[] A) {
        //way 1
        
        //         if (A == null || A.length == 0)     return 0;
        //         int max = A[0], min = A[0], result = A[0];
        //         for (int i = 1; i < A.length; i++) {
        //             int temp = max;
        //             max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
        //             min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
        //             if (max > result) {
        //                 result = max;
        //             }
        //         }
        //         return result;

        //way2
        int product = 1;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            product = product * A[i];
            result = Math.max(product, result);
            if (product == 0) {
                product = 1;
            }
        }

        product = 1;

        for (int i = A.length - 1; i >= 0; i--) {
            product = product * A[i];
            result = Math.max(product, result);
            if (product == 0) {
                product = 1;
            }
        }

        return result;
    }
}
