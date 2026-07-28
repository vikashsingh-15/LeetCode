class Solution {
    public String smallestPalindrome(String s) {
         int[] frequency = new int[26];

        for (char ch : s.toCharArray()) {
            frequency[ch - 'a']++;
        }

        StringBuilder firstHalf = new StringBuilder();
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            int halfCount = frequency[i] / 2;

            for (int j = 0; j < halfCount; j++) {
                firstHalf.append((char) ('a' + i));
            }

            if (frequency[i] % 2 == 1) {
                middle = (char) ('a' + i);
            }
        }

        StringBuilder answer = new StringBuilder(firstHalf);

        if (middle != 0) {
            answer.append(middle);
        }

        answer.append(new StringBuilder(firstHalf).reverse());

        return answer.toString();
    }
}