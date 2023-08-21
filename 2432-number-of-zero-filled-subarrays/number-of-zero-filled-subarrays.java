class Solution {
    public long zeroFilledSubarray(int[] nums) {
        //  long res = 0;
        // int apoint=0;
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] != 0){
        //         apoint = i; 
        //     }
        //     res += i - apoint + 1;
        //     System.out.println("res at "+i+" = "+res);
        // }
        // return res;


        //way 2 ---fail for very long input
        long count = 0;  
        long consecutiveZeros = 0;  
        
        for (int num : nums) {
            if (num == 0) {
                consecutiveZeros++;
                count += consecutiveZeros;  // Increment count by the count of consecutive zeros
            } else {
                consecutiveZeros = 0;  // Reset consecutive zeros count
            }
        }
        
        return count;
    }
}

