class Solution {

    public int appendCharacters(String s, String t) {
        int apoint = 0;
        int bpoint = 0;

        while (apoint < s.length() && bpoint < t.length()) {
            if (s.charAt(apoint) == t.charAt(bpoint)) {
                apoint++;
                bpoint++;
            } else {
                apoint++;
            }
        }
        
        return t.length()-bpoint;
    }
}
