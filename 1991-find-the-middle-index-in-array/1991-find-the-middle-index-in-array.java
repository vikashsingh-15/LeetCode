class Solution {
    public int findMiddleIndex(int[] nums) {
            
        int sum=0;   
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        
        int rightSum=sum;
        int leftSum=0;        
        for(int i=0;i<nums.length;i++){
            rightSum -= nums[i];
            if(rightSum == leftSum) {
                    return i;
                }
            leftSum+=nums[i];
        }
        
        return -1;
    }
}