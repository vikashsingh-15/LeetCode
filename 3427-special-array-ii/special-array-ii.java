//TLE
// class Solution {
//     public boolean[] isArraySpecial(int[] nums, int[][] queries) {
//          boolean[] ans = new boolean[queries.length];

//         for (int i = 0; i < queries.length; i++) {
//             int a = queries[i][0];
//             int b = queries[i][1];
//             boolean isSpecial = true;
//             for (int j = a; j < b; j++) {
//                 if ((nums[j] % 2 == 0 && nums[j + 1] % 2 == 0) || 
//                     (nums[j] % 2 != 0 && nums[j + 1] % 2 != 0)) {
//                     isSpecial = false;
//                     break;
//                 }
//             }
//             ans[i] = isSpecial;
//         }
//         return ans;
//     }
// }


//way 2

class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
         boolean[] ans = new boolean[queries.length];
         int prefix[]=new  int [nums.length];
         prefix[0]=0;

         for(int i=1;i<nums.length;i++){
            if(nums[i]%2==nums[i-1]%2){
                prefix[i]=prefix[i-1]+1;
            }else{
                prefix[i]=prefix[i-1];
            }

         }

       for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];

            ans[i] = prefix[end] - prefix[start] == 0;
        }

        return ans;
    }
}


