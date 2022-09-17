class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
      for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
            
                if(matrix[i].length==1){
                    if(matrix[i][j]==target){
                        return true;
                    } 
                }
                int low=0;
                int high=matrix[i].length-1;
                     
                while(low<=high){ 
                       int mid=(low+(high-low)/2);
                    // System.out.println(mid);
                    // int mid=(low+high)/2;
                    
                    if(matrix[i][mid]==target){
                        return true;
                    }
                    else if(matrix[i][mid]>target){
                    
                         high=mid-1;
                    }
                    else{
                           low=mid+1;
                    }            
                }    
            }
        }
        
        return false;
    }
    
}