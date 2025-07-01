//wrong for "ere" output=2 exp=1
// class Solution {
//     public int possibleStringCount(String s) {
//         int n = s.length();
//         HashSet<Character> set = new HashSet<>();

//         for (char c : s.toCharArray()) {
//             set.add(c);
//         }

//         return n - set.size() + 1;
//     }
// }

////way 2

class Solution {

    public int possibleStringCount(String word) {
        int n = word.length(), ans = 1;
        for (int i = 1; i < n; ++i) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                ans++;
            }
        }
        return ans;
    }
}