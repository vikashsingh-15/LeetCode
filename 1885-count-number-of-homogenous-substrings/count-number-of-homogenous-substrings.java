class Solution {
    public int countHomogenous(String s) {
        int left = 0;
        long res = 0;
        
        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(left) == s.charAt(right)) {
                res += right - left + 1;
            } else {
                res += 1;
                left = right;
            }
        }

        return (int) (res % (1000000007));       
    }
}




//BUG IN CODE at testcase 83.
// class Solution {
//     public int countHomogenous(String s) {
//         long count = 0;
//         char currentChar = s.charAt(0);
//         int currentLength = 1;

//         for (int i = 1; i < s.length(); i++) {
//             if (s.charAt(i) == currentChar) {
//                 currentLength++;
//             } else {
//                 count += currentLength * (currentLength + 1) / 2;
//                 currentChar = s.charAt(i);
//                 currentLength = 1;
//             }
//         }

//         count += currentLength * (currentLength + 1) / 2;
//         return (int)count % 1000000007;
//     }
// }


