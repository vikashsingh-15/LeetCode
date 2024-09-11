// class Solution {
//     public int minBitFlips(int start, int goal) {
//         int xorValue = start ^ goal;
        
//         // Convert the XOR value to a binary string
//         String binaryDiff = Integer.toBinaryString(xorValue);
        
//         // Count the number of '1's in the binary string
//         int countOfFlips = 0;
//         for (char bit : binaryDiff.toCharArray()) {
//             if (bit == '1') {
//                 countOfFlips++;
//             }
//         }
        
//         return countOfFlips;
//     }
// }

//way 2

class Solution {
    public int minBitFlips(int start, int goal) {
        // Calculate the XOR value to find differing bits
        int xorValue = start ^ goal;
        
        // Count the number of 1's in the binary representation of xorValue
        int countOfFlips = 0;
        while (xorValue > 0) {
            // Increment the count if the least significant bit is 1
            countOfFlips += (xorValue & 1);
            // Right shift xorValue to check the next bit
            xorValue >>= 1;
        }
        
        return countOfFlips;
    }
}
