// wrong for n=6 and arr=[[4,0,5,2],[0,5,4,6],[4,5,6,6]] because Each of the three resulting sections formed by the cuts contains at least one rectangle. cant be verified

// class Solution {
//     public boolean checkValidCuts(int n, int[][] arr) {
//         int alongx[] = new int[n];
//         int alongy[] = new int[n];

//         for (int i = 0; i < arr.length; i++) {  
//             int xstart = arr[i][0];
//             int xend = arr[i][2];
//             int ystart = arr[i][1];
//             int yend = arr[i][3]; 

//             for (int j = xstart + 1; j < xend; j++) {
//                 alongx[j]++;
//             }

//             for (int j = ystart + 1; j < yend; j++) {
//                 alongy[j]++;
//             }
//         }

//         for(int i=0;i<alongx.length;i++){
//             System.out.print(alongx[i]+" ");
//         }
//         System.out.println();
//           for(int i=0;i<alongx.length;i++){
//             System.out.print(alongy[i]+"  ");
//         } 

//         int countX = 0;
//         for (int i = 1; i < n; i++) {  
//             if (alongx[i] == 0) {
//                 countX++;
//             }
//         }
//         if (countX >= 2) {  
//             return true;
//         }

       
//         int countY = 0;
//         for (int i = 1; i < n; i++) {  
//             if (alongy[i] == 0) {
//                 countY++;
//             }
//         }
//         if (countY >= 2) {  
//             return true;
//         }

//         return false; 
//     }
// }

////way 2
import java.util.*;

class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> hor = new ArrayList<>();
        List<int[]> vert = new ArrayList<>();

        for (int[] rect : rectangles) {
            hor.add(new int[]{rect[0], rect[2]}); 
            vert.add(new int[]{rect[1], rect[3]}); 
        }

        if (mergeAndCheck(hor) || mergeAndCheck(vert)) {
            return true;
        }
        return false;
    }

    private boolean mergeAndCheck(List<int[]> intervals) {
        if (intervals.isEmpty()) return false;

        Collections.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            int[] last = merged.get(merged.size() - 1);
            int[] curr = intervals.get(i);

            if (curr[0] < last[1]) { 
                last[1] = Math.max(last[1], curr[1]);
            } else {
                merged.add(curr);
            }
        }

        return merged.size() >= 3; 
    }
}
