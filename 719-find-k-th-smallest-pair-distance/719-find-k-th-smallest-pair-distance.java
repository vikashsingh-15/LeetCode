class Solution {

    public int smallestDistancePair(int[] nums, int k) {
        //WAY 1
        Arrays.sort(nums);

            int lo = 0;
            int hi = nums[nums.length - 1] - nums[0];
            while (lo < hi) {
                int mi = (lo + hi) / 2;
                int count = 0, left = 0;
                for (int right = 0; right < nums.length; ++right) {
                    while (nums[right] - nums[left] > mi) left++;
                    count += right - left;
                }
                //count = number of pairs with distance <= mi
                if (count >= k) hi = mi; else lo = mi + 1;
            }
            return lo;

        
        
        //Way 2 ----- T.L.E
        
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // for(int i=0;i<nums.length-1;i++){
        //     for(int j=i+1;j<nums.length;j++){
        //         int diff=Math.abs(nums[j]-nums[i]);
        //         pq.add(diff);
        //         if(pq.size()>k){
        //             pq.poll();
        //         }
        //     }
        // }
        // int x=pq.peek();
        // return x;

        //

    }
}
