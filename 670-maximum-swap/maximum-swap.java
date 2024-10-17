////wrong approach Input
// num =98368
// Output=98368
// Expected=98863

// class Solution {
//     public int maximumSwap(int num) {
//         String str = String.valueOf(num);
//         int maxNum = num; 
//         int maxDigit = -1;
//         int maxPos = -1;

//         for (int i = 0; i < str.length(); i++) {
//             int temp = str.charAt(i) - '0';
//             if (temp > maxDigit) {
//                 maxDigit = temp;
//                 maxPos = i;
//             }
//         }
        
//         StringBuilder sb = new StringBuilder(str);
//         for (int i = 0; i < str.length(); i++) {
//             if (i != maxPos) {
               
//                 char ch = sb.charAt(i);
//                  sb.setCharAt(i,  (char) (maxDigit + '0'));
//                 sb.setCharAt(maxPos,  ch);
                
//                 int num1 = Integer.parseInt(sb.toString());
//                 maxNum = Math.max(maxNum, num1);
                
//                 // Restore original positions for next iteration
//                 sb.setCharAt(maxPos,  (char) (maxDigit + '0'));
//                  sb.setCharAt(i, ch);
//             }
//         }

//         return maxNum;
//     }
// }

class Solution {
    public int maximumSwap(int num) {
         StringBuilder sb = new StringBuilder(Integer.toString(num));
        int maxNum = num; 

        for (int i = 0; i < sb.length(); i++) {
            for (int j = i + 1; j < sb.length(); j++) {
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);
                
                // Convert back to integer
                int newNum = Integer.parseInt(sb.toString());
                maxNum = Math.max(maxNum, newNum);
                

                temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);
            }
        }

        return maxNum;
    }
}

