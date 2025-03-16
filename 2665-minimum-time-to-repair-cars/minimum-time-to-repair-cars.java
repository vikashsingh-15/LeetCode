class Solution {
    public long repairCars(int[] ranks, int cars) {
       long low=0;
       long high=1L*ranks[0]*cars*cars;

       while(low<high){
        long mid=(low+high)/2;
        long carRep=0;

        for(int i=0;i<ranks.length;i++){
           carRep+=(long)(Math.sqrt((1.0*mid)/ranks[i]));
        }

        if(carRep<cars){
            low=mid+1;
        }else{
            high=mid;
        }
       }  
       return low;      
    }
}