// class Solution {

//     public String reverseWords(String s) {
//         s = s + " ";
//         String str = "";
//         String word = "";
//         for (int i = 0; i < s.length(); i++) {
//             char c = s.charAt(i);
//             if (c != ' ') {
//                 word = String.valueOf(c) + word;
//             } else {
//                 str = str + word + " ";
//                 word = "";
//             }
//         }
//         return str.trim();
//     }
// }

////way 2

// class Solution {
//     public String reverseWords(String s) {
//         String[] strArr = s.split("\\s+");
//         StringBuilder res = new StringBuilder();
//         int len = strArr.length;
//         for (int i = 0; i < len; i++) {
//             StringBuilder sb = new StringBuilder(strArr[i]);
//             res.append(sb.reverse());
//             res.append(" ");
//             // if(i < len-1){
//             //     res.append(" ");
//             // }
//         }
//         return res.toString().trim();
//     }
// }



////way 3

class Solution {

    public String reverseWords(String s) {
        final StringBuilder result = new StringBuilder();
        final StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else {
                result.append(word.reverse());
                result.append(" ");
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }
}
