////way 1

class Solution {
    public int rob(int[] nums) {
        int rob=0;
        int noRob=0;

        for(int i=0;i<nums.length;i++){
            int newRob=noRob+nums[i];
            int newNoRob=Math.max(rob,noRob); //2,1,1,2
            // int newNoRob=rob; 
            rob = newRob;
            noRob = newNoRob;
        }
        return Math.max(rob, noRob);
    }
}

