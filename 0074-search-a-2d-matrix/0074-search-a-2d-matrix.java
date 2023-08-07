class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        ////way 1

              for(int i=0;i<matrix.length;i++){
                        if(matrix[i].length==1){
                            if(matrix[i][0]==target){
                                return true;
                            }
                        }
                        int low=0;
                        int high=matrix[i].length-1;

                        while(low<=high){
                               int mid=(low+(high-low)/2);
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
        
        return false;
                }
}
