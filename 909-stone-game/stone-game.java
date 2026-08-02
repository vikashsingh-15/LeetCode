// class Solution {
//     public boolean stoneGame(int[] nums) {
//         return canFirstWin(nums,0,nums.length-1)>0;
//     }
//         public int canFirstWin (int nums[],int start,int end){
//         if(start==end){
//             return nums[start];
//         }

//         int chooseFirst=nums[start]-canFirstWin(nums,start+1,end);
//         int chooseEnd=nums[end]-canFirstWin(nums,start,end-1);

//         return Math.max(chooseFirst, chooseEnd);
//     }
// }


// way 2  memo




class Solution {

    Map<String, Integer> memo = new HashMap<>();

    public boolean stoneGame(int[] nums) {
        return canFirstWin(nums, 0, nums.length - 1) > 0;
    }

    public int canFirstWin(int[] nums, int start, int end) {

        if (start == end) {
            return nums[start];
        }

        String key = start + "," + end;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int chooseFirst =
                nums[start] - canFirstWin(nums, start + 1, end);

        int chooseEnd =
                nums[end] - canFirstWin(nums, start, end - 1);

        int result = Math.max(chooseFirst, chooseEnd);

        memo.put(key, result);

        return result;
    }
}