class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;

        while(left<=right){
            int mid=left+(right-left)/2;

            if(nums[mid]==target){
                return mid;
            }

            if(nums[left]<=nums[mid]){ //eg - 4 5 6 7 0 1 2
                if(nums[left]<=target && target<=nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else{  // eg - 6 7 0 1 2 4 5 
                if(nums[mid]<=target && target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }

        return -1;
    }
}