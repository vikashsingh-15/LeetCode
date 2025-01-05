
////TLE
// class Solution {
//     public String shiftingLetters(String s, int[][] shifts) {
//         char[] c = s.toCharArray();

//         for (int j = 0; j < shifts.length; j++) {
//             int start = shifts[j][0];
//             int end = shifts[j][1];
//             int change = shifts[j][2];

//             for (int i = start; i <= end; i++) {
//                 if (change == 1) {
//                     c[i] = (char) ('a' + (c[i] - 'a' + 1) % 26);
//                 } else {
//                     c[i] = (char) ('a' + (c[i] - 'a' - 1 + 26) % 26);
//                 }
//             }
//         }

//         return new String(c);
//     }
// }

////
class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        char[] result = s.toCharArray();
        int[] diffArr = new int[s.length()];

        for (int[] shift : shifts) {
            int start = shift[0], end = shift[1], direction = shift[2];
            if (direction == 1) { // Backward shift
                diffArr[start]++;
                if (end + 1 < s.length()) {
                    diffArr[end + 1]--;
                }
            } else { // Forward shift
                diffArr[start]--;
                if (end + 1 < s.length()) {
                    diffArr[end + 1]++;
                }
            }
        }

        int numberOfShifts = 0;
        for (int i = 0; i < s.length(); i++) {
            numberOfShifts = (numberOfShifts + diffArr[i]) % 26;
            result[i] = (char) ('a' + (result[i] - 'a' + numberOfShifts + 26) % 26); 
        }

        return new String(result); 
    }
}
