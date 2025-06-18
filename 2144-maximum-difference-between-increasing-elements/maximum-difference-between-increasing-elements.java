class Solution {
    public int maximumDifference(int[] nums) {
        int smallest=Integer.MAX_VALUE;
        int ans=-1;

        for(int i=0;i<nums.length;i++){
            smallest=Math.min(smallest,nums[i]);

            if(smallest<nums[i]){
                ans=Math.max(ans,(nums[i]-smallest));
            }

        }
        return ans;
    }
}