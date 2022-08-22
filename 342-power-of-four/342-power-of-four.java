class Solution {
    public boolean isPowerOfFour(int n) {
        
//         if(n<=0) return false;
//         if(n==1) return true;
        
//         while(n>1) {
//             if(n%4!=0) return false;
//             n/=4;
//         }
//         return true;
        
        
        
        // int x = (int)(Math.log(n)/Math.log(4));
        // if(Math.pow(4,x)%n==0) return true;
        // return false;
        
        
        
        if(n<0){
            return false;
        }
          return  (n & (n-1)) == 0 && (n-1)%3==0;
        
        //(n & (n-1)) == 0 is there to check if the binary representation of the number has only one 1 in it becaues binary representation of  power of 4 has only 1 in it
        
        //(n-1)%3==0 is to check 4 to the power x minus 1 is divisible by 3. This is mathematically true for all powers of 4
        
        
    }
}