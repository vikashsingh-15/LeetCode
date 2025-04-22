////way1 wrong approach.

// class Solution {

//     public int numberOfArrays(int[] differences, int lower, int upper) {
//         int sum=0;
//         int min=0;
//         int max=0;      
//         for (int d : differences) {
//             sum+=d;
//             min=Math.min(sum,min);
//             max=Math.max(sum,max);           
//         }

//         int start=lower+Math.abs(min);
//         int end=start+Math.abs(max);

//         int ans=upper-end+1;
//         if(ans<0){
//             return 0;
//         }
//         return ans;
      
//     }
// }

////way 2

class Solution {

    public int numberOfArrays(int[] differences, int lower, int upper) {
        long sum = 0;
        long min = 0;
        long max = 0;

        for (int d : differences) {
            sum += d;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        long startMin = lower - min; // minimum value that first element can be
        long startMax = upper - max; // maximum value that first element can be

        int ans = (int)(startMax - startMin + 1);

        if (ans < 0) {
            return 0;
        }

        return ans;
    }
}
