class Solution {

    public int smallestDistancePair(int[] nums, int k) {
        
        // WAY 1
        Arrays.sort(nums);
        int length = nums.length;
        int maxDiff = nums[length - 1] - nums[0]; 
        int start = 0;
        int end = maxDiff;
        while(start < end){
            int mid = start + (end - start)/2;//hum log mid nikal kar dekhenghe kki wo mid hum .og aka ans ho shakta hai ya nahi
                                                     //i.e uss mid ke liye kya humey less than eqiual to k kaam difference ka pair                                                              //mil raha hai ya nahi.
            int ans=isPair(nums,mid,k); 
                if(ans<k){
                    start=mid+1;
                }else{
                    end=mid;
                }
        } 
        //This value in start will be the difference with atmost k-pairs having this difference
        return start;
  
        //WAY 2
//         Arrays.sort(nums);

//             int lo = 0;
//             int hi = nums[nums.length - 1] - nums[0];//max diff
//             while (lo < hi) {
//                 int mi = (lo + hi) / 2;
//                 int count = 0, left = 0;
//                 for (int right = 0; right < nums.length; ++right) {
//                     while (nums[right] - nums[left] > mi) left++;
//                     count += right - left;
//                 }
//                 //count = number of pairs with distance <= mi
//                 if (count >= k) hi = mi; else lo = mi + 1;
//             }
//             return lo;
        
        

    
        
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
    
    public int isPair(int[] nums, int mid, int k){     //finding out how ,any code have absolute diff less than mid
        int count = 0;
        int i = 0;
        for(int j = 1; j<nums.length; j++){
            while(nums[j] - nums[i] > mid){
                 i++;
            }
               
            count += j-i;
        }
        return count;
    }
}
