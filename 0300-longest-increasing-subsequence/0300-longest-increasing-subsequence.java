class Solution {
    public int lengthOfLIS(int[] nums) {
        int max=Integer.MIN_VALUE;
        int arr[]=new int [nums.length];
        arr[0]=1;
       int ans=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            max=0;
            for(int j=0;j<=i;j++){
                if(nums[j]<nums[i] ){
                    max=Math.max(max,arr[j]);
                }
            }
            
            arr[i]=max+1;
             ans=Math.max(ans,arr[i]);
            
        }
        return ans==Integer.MIN_VALUE?1:ans;
    }
}