class Solution {
    public int minBitFlips(int start, int goal) {
        int xorValue = start ^ goal;
        
        // Convert the XOR value to a binary string
        String binaryDiff = Integer.toBinaryString(xorValue);
        
        // Count the number of '1's in the binary string
        int countOfFlips = 0;
        for (char bit : binaryDiff.toCharArray()) {
            if (bit == '1') {
                countOfFlips++;
            }
        }
        
        return countOfFlips;
    }
}