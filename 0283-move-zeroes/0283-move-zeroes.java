class Solution {
    public void moveZeroes(int[] nums) {
                
        int j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j++;
            }
            
        }
        
//         int i=0,j=0;
        
//         while(i<nums.length){
//             while(j<nums.length&& nums[j]!=0){
//                 j++;     
//             }
            
//             if(j==nums.length){break;}//you got a j with zero
            
//             i=j+1;
//             while(i<nums.length&& nums[i]==0){
//                 i++;     
//             }
            
//             if(i==nums.length){break;}
            
//             int temp=nums[i];
//             nums[i]=nums[j];
//             nums[j]=temp;
//             j++;
            
            
//         }
    }
}