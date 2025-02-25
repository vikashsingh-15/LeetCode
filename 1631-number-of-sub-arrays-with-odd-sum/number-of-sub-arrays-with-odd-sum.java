class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int count = 0;
        int preSum = 0;
        int oddCount = 0;
        int evenCount = 1; 

        for (int num : arr) {
            preSum += num;

            if (preSum % 2 == 0) {  
                count = (count + oddCount) % MOD;
                evenCount++;
            } else {  
                count = (count + evenCount) % MOD;
                oddCount++;
            }
        }
        return count;
    }
}

//// way 2--> TLE

// class Solution {
//     public int numOfSubarrays(int[] arr) {
//         int count=0;
//         for(int i=0;i<arr.length;i++){
//             int currentSum = 0;
//             for(int j=i;j<arr.length;j++){
//                 currentSum += arr[j];

//                 if(currentSum%2!=0){
//                     count++;
//                 }
//             }
//         }
//          return count % 1_000_000_007;
//     }
// }
