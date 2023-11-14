//case 1-> TLE

// class Solution {
//     Set<String> set = new HashSet<>();

//     public int countPalindromicSubsequence(String s) {
//         int count = 0;
//         int n = s.length();

//         for (int i = 0; i < n - 2; i++) {
//             for (int j = i + 1; j < n - 1; j++) {
//                 for (int k = j + 1; k < n; k++) {
//                     isPalindrome(s.charAt(i), s.charAt(j), s.charAt(k));
//                 }
//             }
//         }

//         return set.size();
//     }

//     private void isPalindrome(char a, char b, char c) {
//         if (a == c) {
//             set.add("" + a + b + c);
//         }
//     }
// }



//case 2 TLE

// class Solution {
//     Set<String> set = new HashSet<>();

//     public int countPalindromicSubsequence(String s) {
//         List<String> subsequences = generateSubsequences(s);
//         return set.size();
//     }

//     public List<String> generateSubsequences(String s) {
//         List<String> subsequences = new ArrayList<>();
//         generateSubsequencesHelper(s, 0, new StringBuilder(), subsequences);
//         return subsequences;
//     }

//     private void generateSubsequencesHelper(String s, int index, StringBuilder current, List<String> subsequences) {
//         if (current.length() == 3) {
//             if (current.charAt(0) == current.charAt(2)) {
//                 set.add(current.toString());
//             }
//             return;
//         }

//         for (int i = index; i < s.length(); i++) {
//             current.append(s.charAt(i));
//             generateSubsequencesHelper(s, i + 1, current, subsequences);
//             current.deleteCharAt(current.length() - 1);
//         }
//     }
// }


//code 3 TLE

class Solution {
    public int countPalindromicSubsequence(String s) {
        int result = 0;
        int n = s.length();
           Set<String> set = new HashSet<>();

        for (char c = 'a'; c <= 'z'; c++) {
            int firstOccurrence = s.indexOf(c);
            int lastOccurrence = s.lastIndexOf(c);

            if (firstOccurrence != -1 && lastOccurrence != -1 && firstOccurrence < lastOccurrence) {
             
                for (int i = firstOccurrence + 1; i < lastOccurrence; i++) {
                    set.add(""+c+s.charAt(i)+c);
                }
            }
        }

        return set.size();
    }
}

//code 4

// class Solution {
//     public int countPalindromicSubsequence(String s) {
//         int result = 0;
//         int n = s.length();

//         for (char c = 'a'; c <= 'z'; c++) {
//             int firstOccurrence = s.indexOf(c);
//             int lastOccurrence = s.lastIndexOf(c);

//             if (firstOccurrence != -1 && lastOccurrence != -1 && firstOccurrence < lastOccurrence) {
//                 Set<Character> uniqueChars = new HashSet<>();
//                 for (int i = firstOccurrence + 1; i < lastOccurrence; i++) {
//                     uniqueChars.add(s.charAt(i));
//                 }
//                 result += uniqueChars.size();
//             }
//         }

//         return result;
//     }
// }



