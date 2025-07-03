class Solution {
    public char kthCharacter(int k) {
        String s = "a";

        while (s.length() < k) {
            String temp = "";
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == 'z') {
                    ch = 'a';
                } else {
                    ch = (char)(ch + 1);
                }
                temp += ch;
            }
            s += temp;
        }

        return s.charAt(k - 1);
    }
}
