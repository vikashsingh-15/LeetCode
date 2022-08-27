class Solution {
   
    public boolean stoneGame(int[] arr) {
         int aliceCount=0;
    int bobCount=0;
        int apoint=0;
        int bpoint=arr.length-1;
        int turn=0;
       while(apoint<bpoint){
           if(turn%2==0){
               if(arr[apoint]>=arr[bpoint]){
                   aliceCount+=arr[apoint];
                   apoint++;
               }else{
                  aliceCount+=arr[bpoint];
                   bpoint--; 
               }
           }else{
               if(arr[apoint]>=arr[bpoint]){
                   bobCount+=arr[apoint];
                   apoint++;
               }else{
                  bobCount+=arr[bpoint];
                   bpoint--; 
               }
           }
           
       }
        
        return aliceCount>bobCount;
        
        
    }
}