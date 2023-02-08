class Solution {

    public int jump(int[] nums) {
        // //way 1
        // Integer dp[] = new Integer[nums.length];
        // dp[nums.length - 1] = 0;
        // int steps = 0;
        // for (int i = nums.length - 2; i >= 0; i--) {
        //     steps = nums[i];
        //     int min = Integer.MAX_VALUE;
        //     for (int j = 1; j <= steps && i + j < nums.length; j++) {
        //         if (dp[i + j] != null) {
        //             min = Math.min(dp[i + j], min);
        //         }
        //         if (min != Integer.MAX_VALUE) {
        //             dp[i] = min + 1;
        //         }
        //     }
        // }
        // return dp[0];
        
        //way 2
        
        int length = nums.length;
        int end = 0;
        int maxPosition = 0; 
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
