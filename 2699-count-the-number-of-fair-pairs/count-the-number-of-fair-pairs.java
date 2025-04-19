////TLE

// class Solution {
//     public long countFairPairs(int[] nums, int lower, int upper) {
//         int count=0;

//         for(int i=0;i<nums.length-1;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(((nums[i]+nums[j])>=lower)&&(nums[i]+nums[j])<=upper){
//                     count++;
//                 }
//             }
//         }

//         return count;
//     }
// }

////way 2 TLE
// class Solution {
//     public long countFairPairs(int[] nums, int lower, int upper) {
//         Arrays.sort(nums);

//         int apoint=0;
//         int bpoint=nums.length;
//         long count=0;
//         for(int i=0;i<nums.length-1;i++){
//             apoint=i+1;
//             bpoint=nums.length-1;
//             while(apoint<nums.length && nums[i]+nums[apoint]<lower ){
//                 apoint++;
//             }

//             while(bpoint>i && nums[i]+nums[bpoint]>upper){
//                 bpoint--;
//             }
//             if (apoint <= bpoint) {
//                 count += (bpoint - apoint + 1);
//             }
//         }
//         return count;
//     }
// }

// WAY 3

class Solution {

    long lower_bound(int[] arr, int low, int high, int element) {
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if(arr[mid]>=element){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }

    long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            long low=lower_bound(nums,i+1,nums.length-1,lower-nums[i]);
            long high=lower_bound(nums,i+1,nums.length-1,upper-nums[i]+1);
          
            ans += 1 * (high - low);
        }
        return ans;
    }
}
