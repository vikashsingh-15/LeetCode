class Solution {

    public int[] nextGreaterElements(int[] nums) {
        int sol[] = new int[nums.length];

        Stack<Integer> stk = new Stack<>();
        
        for(int i=nums.length-1;i>=0;i--){
            stk.push(nums[i]);
        }

        stk.push(nums[nums.length - 1]);
        for (int i = nums.length - 1; i >= 0; i--) {
            while (stk.size() > 0 && stk.peek() <= nums[i]) {
                stk.pop();
            }
            if (stk.size() == 0) {
                sol[i] = -1;
            } else {
                sol[i] = stk.peek();
            }
            stk.push(nums[i]);
        }

        if (sol[sol.length - 1] == -1) {
            int value = nums[nums.length - 1];

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > value) {
                    sol[sol.length - 1] = nums[i];
                    break;
                }
            }
        }

        return sol;
    }
}
