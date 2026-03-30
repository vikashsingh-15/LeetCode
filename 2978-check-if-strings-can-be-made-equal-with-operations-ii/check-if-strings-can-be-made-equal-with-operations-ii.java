// class Solution {
//     public boolean checkStrings(String s1, String s2) {
//         int n = s1.length();

//         List<Character> s1Even = new ArrayList<>();
//         List<Character> s1Odd = new ArrayList<>();
//         List<Character> s2Even = new ArrayList<>();
//         List<Character> s2Odd = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             if (i % 2 == 0) {
//                 s1Even.add(s1.charAt(i));
//                 s2Even.add(s2.charAt(i));
//             } else {
//                 s1Odd.add(s1.charAt(i));
//                 s2Odd.add(s2.charAt(i));
//             }
//         }

//         Collections.sort(s1Even);
//         Collections.sort(s1Odd);
//         Collections.sort(s2Even);
//         Collections.sort(s2Odd);

//         return s1Even.equals(s2Even) && s1Odd.equals(s2Odd);
//     }
// }


////way 2

class Solution {
    public boolean checkStrings(String s1, String s2) {
       int[] even = new int[26];
        int[] odd = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            } else {
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0) {
                return false;
            }
        }

        return true;
    }
}