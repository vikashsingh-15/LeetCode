// //BFS from 0
// public class Solution {
//     public int[][] updateMatrix(int[][] mat) {
//         int m = mat.length;
//         int n = mat[0].length;
//         int[][] distances = new int[m][n];
//         Queue<int[]> queue = new LinkedList<>();
        
//         // Initialize the distances matrix and enqueue all 0s
//        for(int i=0;i<mat.length;i++){
//             for(int j=0;j<mat[0].length;j++){
//                 if(mat[i][j]==0){
//                     distances[i][j]=0;
//                     queue.add(new  int[]{i,j});
//                 }else{
//                     distances[i][j]=-1;
//                 }
//             }
//        }
        
//         // Directions for moving up, down, left, right
//         int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
//         // Perform BFS
//         while (!queue.isEmpty()) {
//           int[] cell = queue.poll();
//             int x = cell[0], y = cell[1];

//             for(int i=0;i<directions.length;i++){
//                 int nx = x + directions[i][0];
//                 int ny = y + directions[i][1];

//                 if(nx >= 0 && nx < m && ny >= 0 && ny < n && distances[nx][ny]==-1){
//                     distances[nx][ny]=distances[x][y] + 1;
//                     queue.add(new int[]{nx, ny});
//                 }
//             }
//         }
 
//         return distances;
//     }
// }


////Way 2 for it without direction Arrays

import java.util.*;

public class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] distances = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize the distances matrix and enqueue all 0s
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    distances[i][j] = 0;
                    queue.add(new int[]{i, j}); // Add all 0 cells to the queue
                } else {
                    distances[i][j] = -1; // Mark unvisited cells
                }
            }
        }
        
        // Perform BFS (level-by-level processing)
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            // Check the four neighbors directly (up, down, left, right)
            if (x - 1 >= 0 && distances[x - 1][y] == -1) { // up
                distances[x - 1][y] = distances[x][y] + 1;
                queue.add(new int[]{x - 1, y});
            }
            if (x + 1 < m && distances[x + 1][y] == -1) { // down
                distances[x + 1][y] = distances[x][y] + 1;
                queue.add(new int[]{x + 1, y});
            }
            if (y - 1 >= 0 && distances[x][y - 1] == -1) { // left
                distances[x][y - 1] = distances[x][y] + 1;
                queue.add(new int[]{x, y - 1});
            }
            if (y + 1 < n && distances[x][y + 1] == -1) { // right
                distances[x][y + 1] = distances[x][y] + 1;
                queue.add(new int[]{x, y + 1});
            }
        }

        return distances;
    }
}





// BFS from 1 