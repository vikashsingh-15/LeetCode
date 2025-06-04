class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends == 1) {
            return word;
        }

        int n = word.length();
        String res = "";
        for (int i = 0; i < n; i++) {
            int endIndex = Math.min(i + n - numFriends + 1, n);
            String s = word.substring(i, endIndex);
            if (res.compareTo(s) <= 0) {
                res = s;
            }
        }

        return res;
    }
}
