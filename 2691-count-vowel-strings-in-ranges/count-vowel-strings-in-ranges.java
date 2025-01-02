class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {

        int arr[] = new int[words.length + 1];
        arr[0] = 0;
        String vowels = "aeiou";

        for (int i = 0; i < words.length; i++) {
            String currWord = words[i];
            if (vowels.indexOf(currWord.charAt(0)) != -1
                    && vowels.indexOf(currWord.charAt(currWord.length() - 1)) != -1) {
                arr[i + 1] = arr[i] + 1;
            } else {
                arr[i + 1] = arr[i];
            }
        }

         int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            ans[i] = arr[ri + 1] - arr[li]; // Calculate the count of valid strings
        }
        return ans;
    }
}