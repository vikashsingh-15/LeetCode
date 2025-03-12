// class Solution {

//     public int numberOfSubstrings(String s) {
//         int len = s.length();
//         int left = 0, right = 0;
//         int[] freq = new int[3];
//         int total = 0;

//         while (right < len) {
//             char curr = s.charAt(right);
//             freq[curr - 'a']++;
//             while (hasAllChars(freq)) {
//                 total += len - right;
//                 char leftChar = s.charAt(left);
//                 freq[leftChar - 'a']--;
//                 left++;
//             }

//             right++;
//         }

//         return total;
//     }

//     private boolean hasAllChars(int[] freq) {
//         // Check if we have at least one of each character
//         return freq[0] > 0 && freq[1] > 0 && freq[2] > 0;
//     }
// }

////way 2

class Solution {

    public int numberOfSubstrings(String s) {
        int len = s.length();
        int left = 0, right = 0;
        int[] freq = new int[3];
        int total = 0;

        while(right<len){
            char curr = s.charAt(right);
            freq[curr - 'a']++;
             while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                 total += (len - right); 
                freq[s.charAt(left) - 'a']--; 
                left++;
             }
             right++;

        }
        return total;
    }
}

////way 3

// class Solution {
//     public int numberOfSubstrings(String s) {
//         int total = 0, len = s.length();
//         char[] chars = s.toCharArray();
//         int[] lastIndex = new int[3];
//         Arrays.fill(lastIndex, -1);

//         for (int right = 0; right < len; right++) {
//             lastIndex[chars[right] - 'a'] = right;

//             if (lastIndex[0] != -1 && lastIndex[1] != -1 && lastIndex[2] != -1) {
//                 total += Math.min(lastIndex[0], Math.min(lastIndex[1], lastIndex[2])) + 1;
//             }
//         }
//         return total;
//     }
// }
