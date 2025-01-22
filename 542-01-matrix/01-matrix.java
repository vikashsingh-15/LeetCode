//BFS from 0
public class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] distances = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize the distances matrix and enqueue all 0s
       for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    distances[i][j]=0;
                    queue.add(new  int[]{i,j});
                }else{
                    distances[i][j]=-1;
                }
            }
       }
        
        // Directions for moving up, down, left, right
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        // Perform BFS
        while (!queue.isEmpty()) {
          int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for(int i=0;i<directions.length;i++){
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];

                if(nx >= 0 && nx < m && ny >= 0 && ny < n && distances[nx][ny]==-1){
                    distances[nx][ny]=distances[x][y] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
 
        return distances;
    }
}



// BFS from 1 