
// TLE
// class Solution {
//     public int minOperations(int[] nums) {
//         HashSet<Integer>set=new HashSet<>();

//         for(int i=0;i<nums.length;i++){
//             set.add(nums[i]);
//         }
//         int ops=0;
//         boolean flow=false;

//         for(int x:set){
//             if(x==0){
//                 continue;
//             }
//             flow=false;
//             for(int i=0;i<nums.length;i++){
//                 if(nums[i]==x){
//                    if(!flow){
//                     flow=true;
//                     ops++;
//                    } 
//                 }
//                 else if(nums[i]<x){
//                     flow=false;
//                 }

//             }
//         }

//         return ops;
//     }
// }

//way 2


class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int ops = 0;

        for (int num : nums) {
            // Drop all higher levels
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }

            // New increasing height (non-zero)
            if ((stack.isEmpty() || stack.peek() < num) && num != 0) {
                stack.push(num);
                ops++;
            }
        }

        return ops;
    }
}
