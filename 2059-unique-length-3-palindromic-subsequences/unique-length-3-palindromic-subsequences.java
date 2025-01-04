////TLE --> without memeo

// class Solution {
//     public int countPalindromicSubsequence(String s) {
//         Set<String>list=new HashSet<String>();
//         generateSubsequences(s, 0, "", list);
//         return list.size();
//     }

//     public void generateSubsequences(String str, int index, String current, Set<String> list ){
//         if(current.length()==3){
//             if(current.charAt(0)==current.charAt(2)){
//                 list.add(current);
//                 return;
//             }
//         }
//          if (index == str.length()) {
//             return;
//         }
//         generateSubsequences(str,index+1,current+str.charAt(index),list);
//          generateSubsequences(str, index + 1, current, list);
//     }
// }

////way 2 --> memo is also TLE

// class Solution {
//     public int countPalindromicSubsequence(String s) {
//         Set<String> list = new HashSet<>();
//         Map<String, Boolean> memo = new HashMap<>();
//         generateSubsequences(s, 0, "", list, memo);
//         return list.size();
//     }

//     public void generateSubsequences(String str, int index, String current, Set<String> list,
//             Map<String, Boolean> memo) {
//         if (current.length() == 3) {
//             if (current.charAt(0) == current.charAt(2)) {
//                 list.add(current);
//             }
//             return;
//         }

//         if (index == str.length()) {
//             return;
//         }

//         String key = index + "|" + current;
//         if (memo.containsKey(key)) {
//             return;
//         }
//         memo.put(key, true);

//         generateSubsequences(str, index + 1, current + str.charAt(index), list, memo);
//         generateSubsequences(str, index + 1, current, list, memo);
//     }
// }


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