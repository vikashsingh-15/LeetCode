class Solution {
    public double knightProbability(int n, int k, int row, int column) {
         int dir[][]={ { 1, 2 }, { 2, 1 }, { -1, 2 }, { 1, -2 }, { -2, 1 }, { 2, -1 }, { -1, -2 }, { -2, -1 } };//direction array for different moves
        
        
        double curr[][]=new double[n][n];
        double next[][]=new double[n][n];
        
        
        curr[row][column]=1;
        for(int m=0;m<k;m++) //for k number of times a new dp[][] will be made to store the                                            probability of each cell where the knight could jump
        {
           for(int i=0;i<n;i++)
           {
               for(int j=0;j<n;j++)
               {
                   if(curr[i][j]>0.0)// means int the curr matrix knight is in this box
                   {
                       
                       
                       for(int move=0;move<dir.length;move++)//move to different grids with the help                                                               of the direction array
                       {
                          int r=i+dir[move][0];
                           int c=j+dir[move][1];
                           if(r>=0 && c>=0 && r<n && c<n)
                           {
                               next[r][c]+=curr[i][j]/8.0;//the knight will move to one of these 8                                                                    boxes
                           }
                       }
                   }
               }
           }
            curr=next;
            next=new double[n][n];
        }
        double sum=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                sum+=curr[i][j];
            }
        }
        return sum;
    }
}