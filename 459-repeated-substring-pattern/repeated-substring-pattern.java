// class Solution {

//     public boolean repeatedSubstringPattern(String s) {
//         int n = s.length();
//         for (int len = 1; len <= n / 2; len++) {
//             String pattern = s.substring(0, len);
//             StringBuilder repeated = new StringBuilder();
//             for (int i = 0; i < n/len; i++) {
//                 repeated.append(pattern);

//                 if (repeated.toString().equals(s)) {
//                     return true;
//                 }
//             }
//         }
//         return false;
//     }
// }

class Solution {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int len = 1; len <= n / 2; len++) {
            if (n % len == 0) {
                String pattern = s.substring(0, len);
                StringBuilder repeated = new StringBuilder();
                for (int i = 0; i < n / len; i++) {
                    repeated.append(pattern);
                    if (repeated.toString().equals(s)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
