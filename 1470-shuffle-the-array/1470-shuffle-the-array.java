class Solution {

    public int[] shuffle(int[] nums, int n) {
        int part = nums.length / n;
        int length2 = nums.length / part;
        int ans[]=new int [nums.length];
        int k=0;

        for (int i = 0; i < length2; i++) {
            ans[k++]=nums[i];
            for (int j = i + length2; j < nums.length; j = j + length2) {
                ans[k++]=nums[j];  
            }
        }
        return ans;
    }
}
