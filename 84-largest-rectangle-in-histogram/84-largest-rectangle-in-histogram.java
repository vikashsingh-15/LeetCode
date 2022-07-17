class Solution {

    public int largestRectangleArea(int[] arr) {
        int rightSmallest[] = smallerLeft(arr);
        int leftSmallest[] = smallerRight(arr);
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int val = (Math.abs(leftSmallest[i] - rightSmallest[i]) - 1) * arr[i];
            max = Math.max(val, max);
        }

        return max;
    }

    public static int[] smallerLeft(int[] arr) {
        int solLeft[] = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        stk.push(0);
        for (int i = 0; i < arr.length; i++) {
            while (stk.size() > 0 && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }
            if (stk.size() == 0) {
                solLeft[i] = -1;
            } else {
                solLeft[i] = stk.peek();
            }
            stk.push(i); // --> Here we are adding index//stk.push(arr[i]);
        }

        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(solLeft[i]+" ");
        // }
        // System.out.println();
        
        return solLeft;
    }

    public static int[] smallerRight(int[] arr) {
        int solRight[] = new int[arr.length];
        Stack<Integer> stk = new Stack<>();
        stk.push(arr.length - 1);
        for (int i = arr.length - 1; i >= 0; i--) {
            while (stk.size() > 0 && arr[stk.peek()] >= arr[i]) {
                stk.pop();
            }
            if (stk.size() == 0) {
                solRight[i] = arr.length;
            } else {
                solRight[i] = stk.peek();
            }
            stk.push(i); // --> Here we are adding index//stk.push(arr[i]);
        }
        
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(solRight[i]+" ");
        // }
        
        return solRight;
    }
}
