import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 1; 
        int lastEnd = arr[0][1]; 
        for (int i = 1; i < arr.length; i++) {
            if (arr[i][0] > lastEnd) { 
                count++;
                lastEnd = arr[i][1]; 
            }
        }
        return count;
    }
}
