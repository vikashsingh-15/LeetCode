import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();

        queue.add(s);
        visited.add(s);
        String smallest = s;

        while (!queue.isEmpty()) {
            String curr = queue.poll();

            // Update smallest string
            if (curr.compareTo(smallest) < 0) {
                smallest = curr;
            }

            // Operation 1: Add 'a' to odd indices
            String added = addOperation(curr, a);
            if (!visited.contains(added)) {   // fixed syntax
                visited.add(added);
                queue.add(added);
            }

            // Operation 2: Rotate right by 'b'
            String rotated = rotateRight(curr, b);
            if (!visited.contains(rotated)) {
                visited.add(rotated);
                queue.add(rotated);
            }
        }

        return smallest;
    }

    //adding
    public String addOperation(String str, int a) {
        char[] chars = str.toCharArray();
        for (int i = 1; i < chars.length; i += 2) { // increment by 2 for odd indices
            int digit = (chars[i] - '0' + a) % 10;
            chars[i] = (char) (digit + '0');
        }
        return new String(chars);
    }

    //rotated
    private String rotateRight(String s, int b) {
        int n = s.length();
        b = b % n;
        return s.substring(n - b) + s.substring(0, n - b);
    }
}
