// class Solution {
//     public List<String> wordSubsets(String[] words1, String[] words2) {

//         int[] freq = new int[26];
//         for (String word : words2) {
//             int[] temp = new int[26];
//             for (char c : word.toCharArray()) {
//                 temp[c - 'a']++;
//             }
//             for (int i = 0; i < 26; i++) {
//                 freq[i] = Math.max(freq[i], temp[i]);
//             }
//         }

//         List<String> result = new ArrayList<>();
//         for (String word : words1) {

//             int[] copy = Arrays.copyOf(freq, freq.length);

//            for (int i = 0; i < word.length(); i++) {
//                 char ch = word.charAt(i);
//                 if (copy[ch - 'a'] > 0) {
//                     copy[ch - 'a']--;
//                 }
//             }

//             boolean isUniversal = true;
//             for (int i = 0; i < copy.length; i++) {
//                 if (copy[i] > 0) {
//                     isUniversal = false;
//                     break;
//                 }
//             }

//             if (isUniversal) {
//                 result.add(word);
//             }
//         }
        
//         return result;
//     }
// }

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] maxFreq = new int[26];
        for (String word : words2) {
            int[] freq = getCharFrequency(word);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] freq = getCharFrequency(word);
            boolean isUniversal = true;
            for (int i = 0; i < 26; i++) {
                if (freq[i] < maxFreq[i]) {
                    isUniversal = false;
                    break;
                }
            }
            if (isUniversal) {
                result.add(word);
            }
        }
        
        return result;
    }
    private static int[] getCharFrequency(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
}
