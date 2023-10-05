class Solution {

    public int majorityElement(int[] nums) {
        // Way 1
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (num == candidate) {
                count++;
            } else if (count == 0) {
                candidate = num;
            } else {
                count--;
            }
        }

        return candidate;
        //way 2
        // int ans = nums[0];
        // HashMap<Integer, Integer> hm = new HashMap<>();
        // for(int i = 0;i<nums.length;i++){
        //     if(hm.containsKey(nums[i])){
        //         hm.put(nums[i],hm.get(nums[i])+1);
        //         if(hm.get(nums[i]) > nums.length/2){
        //             ans = nums[i];
        //         }
        //     }

        //     else{
        //         hm.put(nums[i],1);
        //     }
        // }
        // return ans;

    }
}
