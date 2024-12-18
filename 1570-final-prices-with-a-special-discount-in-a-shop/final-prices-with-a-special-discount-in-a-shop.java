class Solution {
    public int[] finalPrices(int[] arr) {
         int n = arr.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            result[i] = arr[i] - (stack.isEmpty() ? 0 : stack.peek());
            stack.push(arr[i]);
        }
        
        return result;
    }
}