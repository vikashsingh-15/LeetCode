class Solution {

    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            // System.out.println("Entered");
            return gcdOfStrings(str2, str1);
        }
        if (!str1.startsWith(str2)) {
            return "";
        }
        if (str2.isEmpty()) {
            return str1;
        }
        // System.out.println("Str 1= "+str1);
        // System.out.println("str 2= "+str2);
        // System.out.println("str1.substring(str2.length()) = "+str1.substring(str2.length()));
        return gcdOfStrings(str1.substring(str2.length()), str2);

        // way2
        // if (!(str1 + str2).equals(str2 + str1)){
        //      return "";
        //  }
        //  return str1.substring(0,gcd(str1.length(),str2.length()));

    }
    // public static int gcd(int a, int b) {
    //     return (b == 0 ? a : gcd(b, a % b));
    // }
}
