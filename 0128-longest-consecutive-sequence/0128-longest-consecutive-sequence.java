class Solution {

    public int longestConsecutive(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();

        // for (int v : nums){
        //     set.add(v);
        // }

        if (nums == null || nums.length == 0) {
            return 0;
        }

        for (var i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        ////way 1

        //         int count = 0;
        //         int max = 0;
        //         int prev = set.first();

        //         for (Integer value : set) {
        //             if (value - 1 == prev) {
        //                 count++;
        //             } else {
        //                 count = 0;
        //             }
        //             prev = value;
        //             max = Math.max(count, max);
        //         }
        //         return max + 1;
        
        
        ////Way 2
        
        int count=0;
        int max=0;
        int prev=set.first();
        
        Integer arr[]=set.toArray(new Integer[0]);
        
        for(int i=0;i<arr.length;i++){
            if(arr[i]-1==prev){
                count++;
            }else{
                count=0;
            }
            prev = arr[i];
            max = Math.max(count, max);     
        }
        
        return max+1;
      


    }
}
