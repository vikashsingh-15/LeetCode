// class Solution {
//     public int longestMonotonicSubarray(int[] nums) {
//         int ans=0;
//         int increasing=0;
//         int decreasing =0;


//         for(int i=0;i<nums.length-1;i++){
//             if(nums[i]<nums[i+1]){
//                increasing+=1;
//                decreasing=0;
//             }
//             else if(nums[i]>nums[i+1]){
//                  decreasing+=1;
//                increasing=0;
//             }
//             else{
//                 decreasing=0;
//                 increasing=0;
//             }

//            ans=Math.max(ans,Math.max(increasing,decreasing));
//         }
//         return ans+1;
//     }
// }


////way 2

class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans=1;
        int increasing=1;
        int decreasing =1;


        for(int i=0;i<nums.length-1;i++){
            if(nums[i]<nums[i+1]){
               increasing+=1;
               decreasing=1;
            }
            else if(nums[i]>nums[i+1]){
                 decreasing+=1;
               increasing=1;
            }
            else{
                decreasing=1;
                increasing=1;
            }

           ans=Math.max(ans,Math.max(increasing,decreasing));
        }
        return ans;
    }
}