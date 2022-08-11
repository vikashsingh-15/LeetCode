class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product=1;
        int count=0;
        
        // for(int i=0;i<nums.length;i++){
        //     product=nums[i];
        //      if(product<k){
        //             count++;
        //         }
        //     for(int j=i+1;j<nums.length;j++){
        //          product=(int)product*nums[j];
        //         if(product<k){
        //             count++;
        //         }
        //        else if(product>=k){
        //             product = 1;
        //             break;
        //         }
        //     }
        // }
        
// WAY 2 APPROACH
        if(k<=1){
            return 0;
        }
        
        int left=0;
        int right=0;
        
        while(right<nums.length){
            product*=nums[right];         
            while(product>=k){
                product/=nums[left];
                left++;
            }
            count+=right-left+1;
            
            
            right++;
            
        }
        
        return count;
   }
}