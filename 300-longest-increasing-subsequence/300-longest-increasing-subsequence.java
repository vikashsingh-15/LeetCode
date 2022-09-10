class Solution {
    public int lengthOfLIS(int[] nums) {
        int arr[]=new int [nums.length];
        int ans=Integer.MIN_VALUE;
        arr[0]=1;
        for(int i=1;i<nums.length;i++){
            int max=0;
            for(int j=0;j<i;j++){  
                if(nums[j]<nums[i] && arr[j]>max){
                   max=arr[j];
                } 
            }
            arr[i]=max+1;
            ans=Math.max(ans,arr[i]);//we can do that outside a loop also,just to chech max in arr;
        }
        
        return ans==Integer.MIN_VALUE?1:ans;
    }
}