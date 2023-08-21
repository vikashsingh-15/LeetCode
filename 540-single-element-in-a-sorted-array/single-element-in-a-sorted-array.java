class Solution {

    public int singleNonDuplicate(int[] nums) {
        // int left = 0, right = nums.length - 1;
        // while (left < right) {
        //     int mid = (left + right) / 2;
        //     if (mid % 2 == 1) {
        //         mid--;
        //     }
        //     if (nums[mid] != nums[mid + 1]) {
        //         right = mid;
        //     } else {
        //         left = mid + 2;
        //     }
        // }
        // return nums[left];

        //way 2

        //  int ans = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     ans = ans ^ nums[i];
        // }
        // return ans;

        //         //way 3
        int left = 0;
        int right = nums.length - 1;
        int n = nums.length;

        if (n == 1) {
            return nums[0];
        } else if (nums[0] != nums[1]) {
            return nums[0];
        } else if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            }
            else if(nums[mid]==nums[mid-1]){
                int leftCount=mid-left+1; //no of element left of mid mid included.
                if(leftCount%2==0){//eg 11224466899 //missing element odd no of element ke side hoga
                    left=mid+1;
                }else{
                    right=mid-2;
                }

            }else if (nums[mid]==nums[mid+1]){
                int rightCount=right-mid+1;//no of element left of mid mid included.
                if(rightCount%2==0){//eg 11224668899 //missing element odd no of element ke side hoga
                    right=mid-1;
                }else{
                    left=mid+2;
                }
            }
        }

        return nums[left];
    }
}
