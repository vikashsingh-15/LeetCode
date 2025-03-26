class Solution {
    public int minOperations(int[][] grid, int x) {
         int m = grid.length, n = grid[0].length;
        int[] arr = new int[m * n];
        int index = 0;
        for (int[] row : grid) {
            for (int num : row) {
                arr[index++] = num;
            }
        }

         Arrays.sort(arr);

         int  median=arr.length/2;
         int target=arr[median];
         int count=0;


         for(int num:arr){
            int ops= Math.abs(num - target);
            if(ops%x==0){
               count += ops / x;
            }else{
                return  -1;
            }

         }
        return count;
    }
}