class Solution {
    public String convertToTitle(int n) {
         if (n < 27) {
            return Character.toString((char) ('A' + (n - 1) % 26));
        }
        
        StringBuilder c = new StringBuilder();
         while (n > 0) {
           int remainder = (n - 1) % 26;
           char ch = (char) ('A' + remainder);
           c.insert(0,ch);
           n=(n-1)/26;
        }
        return c.toString();
    }
}