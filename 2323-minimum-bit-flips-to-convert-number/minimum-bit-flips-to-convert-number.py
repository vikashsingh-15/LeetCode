class Solution:
    def minBitFlips(self, start: int, goal: int) -> int:
         xor_value = start ^ goal
        
        # Convert the XOR value to a binary string
         binary_diff = bin(xor_value)
        
        # Count the number of '1's in the binary string
         count_of_flips = 0
         for bit in binary_diff:
            if bit == '1':
                count_of_flips += 1
        
         return count_of_flips