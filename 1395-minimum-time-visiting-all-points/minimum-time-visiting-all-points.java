// class Solution {
//     public int minTimeToVisitAllPoints(int[][] points) {
//         int ans = 0;
//         for (int i = 0; i < points.length - 1; i++) {
//             int currX = points[i][0];
//             int currY = points[i][1];
//             int targetX = points[i + 1][0];
//             int targetY = points[i + 1][1];
//             ans += Math.max(Math.abs(targetX - currX), Math.abs(targetY - currY));
//         }
        
//         return ans;
//     }
// }

////way 2
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;

        for (int i = 1; i < points.length; i++) {

            int x1 = points[i - 1][0];
            int y1 = points[i - 1][1];
            int x2 = points[i][0];
            int y2 = points[i][1];

            int dx = Math.abs(x2 - x1);
            int dy = Math.abs(y2 - y1);

          
            int diagonalMoves = Math.min(dx, dy);
            dx -= diagonalMoves;
            dy -= diagonalMoves;

        
            int straightMoves = dx + dy; 

            totalTime += diagonalMoves + straightMoves;
        }

        return totalTime;
    }
}
