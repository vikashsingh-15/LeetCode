class Solution {
    public String smallestSubsequence(String s) {

        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        Stack<Character> stack = new Stack<>();
        boolean[] used = new boolean[26];

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            // Skip duplicates
            if (used[c - 'a']) {
                continue;
            }

            while (!stack.isEmpty()
                    && stack.peek() > c
                    && last[stack.peek() - 'a'] > i) {

                used[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            used[c - 'a'] = true;
        }

        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        return ans.reverse().toString();
    }
}