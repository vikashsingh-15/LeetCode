class Solution {

    public String addBinary(String a, String b) {
        //way1

        //return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);

        //way 2

        if (a.length() == 0) {
            return b;
        }
        if (b.length() == 0) {
            return a;
        }
        String ans = "";
        int carry = 0;
        int sum = 0;
        int alen = a.length() - 1;
        int blen = b.length() - 1;

        while (alen >= 0 || blen >= 0) {
            sum = carry;
            if (blen >= 0) sum += b.charAt(blen--) - '0';
            if (alen >= 0) sum += a.charAt(alen--) - '0';

            ans = Integer.toString(sum % 2) + (String) ans;
            carry = sum / 2;
        }
        if (carry != 0) {
            ans = Integer.toString(carry) + (String) ans;
        }
        return ans;
        
        
        
        //way 3

        //          StringBuilder sb = new StringBuilder();
        //         int i = a.length() - 1, j = b.length() -1, carry = 0;
        //         while (i >= 0 || j >= 0) {
        //             int sum = carry;
        //             if (j >= 0) sum += b.charAt(j--) - '0';
        //             if (i >= 0) sum += a.charAt(i--) - '0';
        //             sb.append(sum % 2);
        //             carry = sum / 2;
        //         }
        //         if (carry != 0) sb.append(carry);
        //         return sb.reverse().toString();
    }
}
