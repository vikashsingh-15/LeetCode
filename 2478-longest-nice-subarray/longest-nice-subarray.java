class Solution {
    public int longestNiceSubarray(int[] nums) {
        int andSoFar = 0;  
        int maxLength = 0;  
        int apoint = 0;  
        int bpoint = 0;  

        while (bpoint < nums.length) {  
            
            while ((andSoFar & nums[bpoint]) != 0) {
                andSoFar ^= nums[apoint];  
                apoint++;  
            }

            andSoFar |= nums[bpoint];  
            maxLength = Math.max(maxLength, bpoint - apoint + 1);  
            bpoint++;  
        }

        return maxLength;  
    }
}
