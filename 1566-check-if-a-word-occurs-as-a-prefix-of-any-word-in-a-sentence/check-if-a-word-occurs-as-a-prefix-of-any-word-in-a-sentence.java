class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
         String[] str = sentence.split(" ");

        for (int i = 0; i < str.length; i++) {
            if (str[i].startsWith(searchWord)) {
                return i + 1; // Return the 1-based index of the word
            }
        }
        return -1;
    }
}