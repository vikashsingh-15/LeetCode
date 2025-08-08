class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int i = 0;

        //increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) i++;
        if (i == 0 || i >= n - 2) return false; 

        //decreasing
        int peak = i;
        while (i + 1 < n && nums[i] > nums[i + 1]) i++;
        if (i == peak || i >= n - 1) return false; 
        
        //increasing
        while (i + 1 < n && nums[i] < nums[i + 1]) i++;

        return i == n - 1;
    }
}
