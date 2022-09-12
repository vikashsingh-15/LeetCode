class Solution {

    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if(sum%3!=0){
            return false;
        }
        
        int eachSum=sum/3;
        int subSum=0;
        int count=0;
         for (int i = 0; i < arr.length; i++) {
            subSum += arr[i];
             if(subSum==eachSum){
                 count++;
                 subSum=0;
             }
        }
        
     return count>=3?true:false;
       
        
        
    }
}
