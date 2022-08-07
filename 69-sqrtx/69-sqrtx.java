class Solution {

    public int mySqrt(int x) {
        //         long start=0;
        //         long end=x;
        //         while(start<=end){
        //             long mid=start+(end-start)/2;
        //             // System.out.println(mid);
        //             if(mid*mid==x){
        //                 return (int)mid;
        //             }

        //             else if(mid*mid<x){
        //                 start=mid+1;
        //             }else{
        //                 end=mid-1;
        //             }
        //         }

        //         return (int) start-1;
        
        
        //WAy 2
        long val=0;
        while(val*val<=x) val++;
        return (int) val-1;
        
    }
}
