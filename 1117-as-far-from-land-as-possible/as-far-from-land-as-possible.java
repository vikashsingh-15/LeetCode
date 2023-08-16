// class Solution {
// public int maxDistance(int[][] grid) {
//         int n=grid.length;
//         Queue<Pair> q = new LinkedList<>();
//         int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
//         for (int i = 0; i < grid.length; i++) {
//             for (int j = 0; j < grid[0].length; j++) {
//                 if (grid[i][j] == 1) {
//                     q.add(new Pair(i,j));
//                 }
//             }
//         }
        
//         if(q.size() == n*n || q.size()==0){
//             return -1;
//         }
//         int level = -1;
//         while(q.size()>0){
//             level++;
//             int size=q.size();
//             while(size-->0){
//                 Pair remove=q.remove();
//                 for(int i=0;i<4;i++){
//                     int row_Dash=remove.row+dir[i][0];
//                     int col_Dash=remove.col+dir[i][1];
                    
//                     if(row_Dash<0||row_Dash>=n||col_Dash<0||col_Dash>=n||grid[row_Dash][col_Dash]==1){
//                         continue;
//                     }else{
//                         q.add(new Pair(row_Dash,col_Dash));
//                         grid[row_Dash][col_Dash]=1;
//                     }
//                 }
                
//             }
            
//         }
//         return level;
//     }
// }

// public class Pair {
//     int row;
//     int col;

//     Pair(int row, int col) {
//         this.row = row;
//         this.col = col;
//     }
// }


//way 2

class Solution {
    public int maxDistance(int[][] grid) {
         int n = grid.length;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Map<Pair<Integer, Integer>, Integer> visited = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Pair<>(i, j));
                    visited.put(new Pair<>(i, j), 0);
                }
            }
        }
        
        if (queue.isEmpty() || queue.size() == n * n) {
            return -1;
        }
        
        int[][] directions = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
        int maxDistance = -1;
        
        while (!queue.isEmpty()) {
            Pair<Integer, Integer> cell = queue.poll();
            int x = cell.getKey();
            int y = cell.getValue();
            int distance = visited.get(cell);
            
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                Pair<Integer, Integer> newCell = new Pair<>(newX, newY);
                
                if (newX >= 0 && newX < n && newY >= 0 && newY < n && !visited.containsKey(newCell)) {
                    queue.offer(newCell);
                    visited.put(newCell, distance + 1);
                    maxDistance = distance + 1;
                }
            }
        }
        
        return maxDistance;
    }
}


//// BrutForce --> TLE
// class Solution {
//     public int maxDistance(int[][] grid) {
//         int n = grid.length;
//         int maxDistance = -1;
        
//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < n; j++) {
//                 if (grid[i][j] == 0) {
//                     int minDistance = Integer.MAX_VALUE;
//                     for (int x = 0; x < n; x++) {
//                         for (int y = 0; y < n; y++) {
//                             if (grid[x][y] == 1) {
//                                 int distance = Math.abs(x - i) + Math.abs(y - j);
//                                 minDistance = Math.min(minDistance, distance);
//                             }
//                         }
//                     }
//                     maxDistance = Math.max(maxDistance, minDistance);
//                 }
//             }
//         }
        
//         return (maxDistance == Integer.MAX_VALUE) ? -1 : maxDistance;
//     }
// }

