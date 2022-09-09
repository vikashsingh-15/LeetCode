
import java.lang.Math;
class Solution {
    // public int[] plusOne(int[] digits) {
    //     for(int i = digits.length -1; i>=0; i--){
    //         if(digits[i] < 9){
    //             digits[i]++;
    //             return digits;
    //         }
    //         digits[i] = 0;
    //     }
    //     int res[] = new int[digits.length +1];
    //     res[0] = 1;
    //     return res;   
    // }
    
    public int[] plusOne(int[] A) {
         int carry=1,p=0;
        for(int i=A.length-1;i>=p;i--)
        {
            int sum=A[i]+carry;
            A[i]=sum%10;
            carry=sum/10;
        }
        if(carry>0)
        {
            int b[]=new int[A.length+1];
            b[0]=carry;
            for(int i=1;i<A.length+1;i++)
            b[i]=A[i-1];
            return b;
        }
        else
        {
          int pp=0;
          while(A[pp]==0)
          pp++;
            int b[]=new int[A.length-pp];
            for(int i=pp;i<A.length;i++)
            b[i-pp]=A[i];
            return b;
        }
    }
    
    
}