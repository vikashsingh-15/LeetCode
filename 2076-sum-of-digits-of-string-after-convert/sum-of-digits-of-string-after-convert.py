class Solution:
    def getLucky(self, s: str, k: int) -> int:
        num_str = ''.join(str(ord(char) - ord('a') + 1) for char in s)
        
        # for _ in range(k):
        # num_str = str(sum(int(digit) for digit in num_str))


        for _ in range(k):
            digit_sum = 0
            for digit in num_str:
                digit_sum += int(digit)
            num_str = str(digit_sum)

        return int(num_str)

    
