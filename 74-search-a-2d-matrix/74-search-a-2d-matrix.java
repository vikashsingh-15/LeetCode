class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        ////way 1

        //       for(int i=0;i<matrix.length;i++){
        //             for(int j=0;j<matrix[i].length;j++){

        //                 if(matrix[i].length==1){
        //                     if(matrix[i][j]==target){
        //                         return true;
        //                     }
        //                 }
        //                 int low=0;
        //                 int high=matrix[i].length-1;

        //                 while(low<=high){
        //                        int mid=(low+(high-low)/2);
        //                     // System.out.println(mid);
        //                     // int mid=(low+high)/2;

        //                     if(matrix[i][mid]==target){
        //                         return true;
        //                     }
        //                     else if(matrix[i][mid]>target){

        //                          high=mid-1;
        //                     }
        //                     else{
        //                            low=mid+1;
        //                     }
        //                 }
        //             }
        //         }

        //         return false;

        //way 2
        
        
        int len=matrix[0].length;
        int i=0;
        int l=0,h=len-1,mid;
        
        
        while(i<matrix.length && l<=h){
            if(matrix[i][h]<target){
                i++;
            }else{
                mid=(l+h)/2;
                
                if(matrix[i][mid]==target){
                    return true;
                }else if(matrix[i][mid]<target){
                    l=mid+1;
                    // l++;
                }else if(matrix[i][mid]>target){
                    h=mid-1;
                    // h--;
                }
            }
        }
        
        return false;
    }
}
