class Solution {
    public String multiply(String s1, String s2) {
         int n1 = s1.length();
        int n2 = s2.length();
        int[] result = new int[n1 + n2];
        int carry=0;
        int sum=0;
        
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int digit1 = s1.charAt(i) - '0';
                int digit2 = s2.charAt(j) - '0';
                int product = digit1 * digit2;
                int total=product+result[i+j+1]+carry;
                result[i + j + 1] = total % 10;
                carry=total/10;
            }
            result[i] += carry; 
            carry=0;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if ((sb.length() == 0 && num == 0)) {
               
            }else{
                sb.append(num);
            }
        }
        
        return sb.length() == 0 ? "0" : sb.toString();
    }
}