// class Solution {
//     public int maximumSum(int[] nums) {
//         Map<Integer,List<Integer>>map=new HashMap<>();

//         for(int i=0;i<nums.length;i++){
//             int digitSum=sumOfDigit(nums[i]);
//             map.putIfAbsent(digitSum,new ArrayList<>());
//             map.get(digitSum).add(nums[i]);
//         }

//         int maxSum = -1;

//         for( Integer key:map.keySet()){
//             List<Integer> list=map.get(key);
//             if(list.size()>1){
//                 Collections.sort(list, Collections.reverseOrder());
//                 int currentSum = list.get(0) + list.get(1);
//                 maxSum = Math.max(maxSum, currentSum);
//             }
//         }

//         return maxSum;
        
//     }

//     public static int sumOfDigit(int x){
//         int sum=0;
//         while(x!=0){
//             sum+=x%10;
//             x=x/10;
//         }
//         return sum;
//     }
// }

////way 2

import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int num : nums) {
            int digitSum = sumOfDigit(num);
            map.putIfAbsent(digitSum, new PriorityQueue<>(2)); 

            PriorityQueue<Integer> pq = map.get(digitSum);
            pq.offer(num);
         
            if (pq.size() > 2) {
                pq.poll(); 
            }
        }

        int maxSum = -1;
        for (PriorityQueue<Integer> pq : map.values()) {
            if (pq.size() == 2) {
                int sum = pq.poll() + pq.poll(); 
                maxSum = Math.max(maxSum, sum);
            }
        }

        return maxSum;
    }

   
    public static int sumOfDigit(int x) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }
        return sum;
    }
}

