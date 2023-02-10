class Solution {

    public int maxDistance(int[][] grid) {
        int n=grid.length;
        Queue<Pair> q = new LinkedList<>();
        int [][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i,j));
                }
            }
        }
        
        if(q.size() == n*n || q.size()==0){
            return -1;
        }
        int level = -1;
        while(q.size()>0){
            level++;
            int size=q.size();
            while(size-->0){
                Pair remove=q.remove();
                for(int i=0;i<4;i++){
                    int row_Dash=remove.row+dir[i][0];
                    int col_Dash=remove.col+dir[i][1];
                    
                    if(row_Dash<0||row_Dash>=n||col_Dash<0||col_Dash>=n||grid[row_Dash][col_Dash]==1){
                        continue;
                    }else{
                        q.add(new Pair(row_Dash,col_Dash));
                        grid[row_Dash][col_Dash]=1;
                    }
                }
                
            }
            
        }
        return level;
    }
}

public class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
