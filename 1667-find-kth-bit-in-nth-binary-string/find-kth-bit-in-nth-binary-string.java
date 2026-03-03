// class Solution {
//     public char findKthBit(int n, int k) {
//        boolean flip=false;

//        if(k==1){
//         return '0';
//        }

//        while(n>1){
//         int len=(1<<n)-1;
//         int mid=(len+1)/2;

//         if(k==mid){
//             return flip?'0':'1';
//         }
//         if(k>mid){
//             flip=!flip;
//             int eqvK= len - k + 1; 
//             k=eqvK;
//         }
//         n--;
//        }
    
//         return flip ? '1' : '0';
//     }
// }


////way 2

class Solution {

    public char findKthBit(int n, int k) {

        if (n == 1) {
            return '0';
        }

        int len = (1 << n) - 1;
        int mid = len / 2 + 1;

        if (k == mid) {
            return '1';
        }

        if (k < mid) {
            return findKthBit(n - 1, k);
        }

        int mirrorIndex = len - k + 1;
        char ch = findKthBit(n - 1, mirrorIndex);
        return ch == '0' ? '1' : '0';

    }
}
