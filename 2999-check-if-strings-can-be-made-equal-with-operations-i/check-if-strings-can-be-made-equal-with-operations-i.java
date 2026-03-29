// class Solution {
//     public boolean canBeEqual(String s1, String s2) {
//          return ((s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2)) ||
//                 (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0))) &&
//                ((s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3)) ||
//                 (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1)));
   
//     }
// }

//way 2
class Solution {
    public boolean canBeEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return check(s1, s2);
    }

    public boolean check(String s1, String s2) {
        int n = s1.length();
        boolean[] used = new boolean[n];

        for (int i = 0; i < n; i++) {
            boolean found = false;

            // search only in same parity group
            for (int j = i % 2; j < n; j += 2) {
                if (!used[j] && s1.charAt(i) == s2.charAt(j)) {
                    used[j] = true;
                    found = true;
                    break;
                }
            }

            if (!found) return false;
        }

        return true;
    }
}