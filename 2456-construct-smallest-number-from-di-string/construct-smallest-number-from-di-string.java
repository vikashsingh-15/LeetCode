// class Solution {
//     public String smallestNumber(String pattern) {
//          int n = pattern.length();
//         StringBuilder result = new StringBuilder();
//         Stack<Integer> stack = new Stack<>();

//         for (int i = 0; i <= n; i++) {
//             stack.push(i + 1);

//             if (i == n || pattern.charAt(i) == 'I') {
//                 while (!stack.isEmpty()) {
//                     result.append(stack.pop());
//                 }
//             }
//         }
//         return result.toString();
//     }
// }

////way 2

class Solution {
    public String smallestNumber(String pattern) {
        int n = pattern.length();
        char[] result = new char[n + 1];
        for (int i = 0; i <= n; i++) {
            result[i] = (char) ('1' + i);
        }
        int i = 0;
        while (i < n) {
            if (pattern.charAt(i) == 'D') {
                int start = i;
                while (i < n && pattern.charAt(i) == 'D') {
                    i++;
                }
                reverse(result, start, i);
            } else {
                i++;
            }
        }

        return new String(result);
    }

    private void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
