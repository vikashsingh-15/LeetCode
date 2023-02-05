class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        // WAY 1
        List<Integer> ans = new ArrayList<>();
        int n = p.length();
        for (int i = 0; i < s.length() - n + 1; i++) {
            if (isvalidAnagram(s.substring(i, i + n), p)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean isvalidAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] a = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            a[t.charAt(i) - 'a']--;
        }
        for (int j = 0; j < 26; j++) {
            if (a[j] != 0) return false;
        }

        return true;
    }
}
