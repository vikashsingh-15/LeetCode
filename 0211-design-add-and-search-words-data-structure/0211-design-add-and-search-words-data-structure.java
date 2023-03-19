class WordDictionary {

    boolean isEqual(String a, String b) {
        if (a.length() != b.length()) return false;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i) && b.charAt(i) != '.') return false;
        }

        return true;
    }

    HashMap<Integer, ArrayList<String>> hm;

    public WordDictionary() {
        hm = new HashMap<>();
    }

    public void addWord(String word) {
        ArrayList arr = hm.getOrDefault(word.length(), new ArrayList<>());
        arr.add(word);
        hm.put(word.length(), arr);
    }

    public boolean search(String word) {
        ArrayList<String> arr = hm.getOrDefault(word.length(), new ArrayList<>());
        for (String w : arr) {
            if (isEqual(w, word)) return true;
        }
        return false;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
