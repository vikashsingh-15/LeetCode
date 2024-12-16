// class Solution {
//     public int[] getFinalState(int[] nums, int k, int multiplier) {

//         for(int j=0;j<k;j++){
//             int minIdx=0;
//             for(int i=0;i<nums.length;i++){
//                 if(nums[i]<nums[minIdx]){
//                     minIdx=i;
//                 }
//             }
//             nums[minIdx]*=multiplier;
//         }
//         return nums;
//     }
// }

////way 2

class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<int []> map=new PriorityQueue<>((a,b)->{
            int value=Integer.compare(a[0],b[0]);
            if(value==0){
                return Integer.compare(a[1],b[1]);
            }
            return value;
        });
        for(int i=0;i<nums.length;i++){
            map.offer(new int[] {nums[i],i});
        }

        while(k-->0){
           int[] x=map.poll();
            int index=x[1];
            nums[index]*=multiplier;
            map.offer(new int[]{nums[index],index});
        }

        return nums;
    }
}

