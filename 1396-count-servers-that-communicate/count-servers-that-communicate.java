// class Solution {
//     public int countServers(int[][] grid) {
//         int n=grid.length;
//         int m=grid[0].length;
//         int count=0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(grid[i][j]==1&& (checkRow(i,grid) || checkCol(j,grid))){
//                     count++;
//                 }
//             }

//         } 
//         return count;
//     }

//     public static boolean  checkRow(int row,int [][]grid){
//        int serverCount = 0;
//         for (int j = 0; j < grid[0].length; j++) {
//             if (grid[row][j] == 1) {
//                 serverCount++;
//             }
//         }
//         return serverCount > 1;
//     }

//      public static boolean  checkCol(int col,int [][]grid){
//         int serverCount = 0;
//         for (int i = 0; i < grid.length; i++) {
//             if (grid[i][col] == 1) {
//                 serverCount++;
//             }
//         }
//         return serverCount > 1;
//     }
// }


//way 2

class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;


        Map <Integer,Integer>mapx=new HashMap<>();
        Map <Integer,Integer>mapy=new HashMap<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    mapx.put(i,mapx.getOrDefault(i,0)+1);
                    mapy.put(j,mapy.getOrDefault(j,0)+1);
                }
            }

        } 

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && (mapx.get(i)>1 ||mapy.get(j)>1  )){
                    count++;
                }
            }

        } 
        return count;
    }
}