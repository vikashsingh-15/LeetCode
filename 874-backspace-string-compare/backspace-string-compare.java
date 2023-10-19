class Solution {

    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<Character>();
        Stack<Character> s2 = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '#') {
                if (!s1.isEmpty()) {
                    s1.pop();
                }
                continue;
            }
            s1.push(ch);
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (ch == '#') {
                if (!s2.isEmpty()) {
                    s2.pop();
                }
                continue;
            }
            s2.push(ch);
        }

        String res1 = "";
        String res2 = "";

        while (!s1.isEmpty()) res1 += s1.pop();

        while (!s2.isEmpty()) res2 += s2.pop();

        return res1.equals(res2);
    }
}
