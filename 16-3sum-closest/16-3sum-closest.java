class Solution {

    public int threeSumClosest(int[] arr, int target) {
        
        int result= arr[0]+ arr[1]+ arr[2];
        
        Arrays.sort(arr);
        
        for(int i=0;i<arr.length;i++){
            int apoint=i+1;
            int bpoint=arr.length-1;
            
            
            while(apoint<bpoint){
                int currSum=arr[i]+ arr[apoint]+arr[bpoint];
                
                if(currSum>target){
                    bpoint--;
                }
                else{
                    apoint++;
                }
                
                if(Math.abs(result-target)>Math.abs(currSum-target)){
                    result=currSum;
                } 
                
            }   
        }
        
        return result;
    }
}
