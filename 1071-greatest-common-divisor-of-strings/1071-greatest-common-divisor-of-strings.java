class Solution {

    public String gcdOfStrings(String str1, String str2) {
        if (str1 == "") {
            return str2;
        } else if (str2 == "") {
            return str1;
        } else if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        } else if (str1.length() > str2.length()) {
            StringBuilder sb = new StringBuilder(str1);
            sb.delete(str1.length() - str2.length(), str1.length());
            return gcdOfStrings(sb.toString(), str2);
        } else {
            StringBuilder sb1 = new StringBuilder(str2);
            sb1.delete(str2.length() - str1.length(), str2.length());
            return gcdOfStrings(str1, sb1.toString());
        }
    }
}
