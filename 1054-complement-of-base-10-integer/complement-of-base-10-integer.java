// class Solution {
//     public int bitwiseComplement(int n) {
//           if(n == 0){
//             return 1;
//         }

//         int mask = 0;
//         int temp = n;

//         while(temp > 0){
//             mask = (mask << 1) | 1;
//             temp >>= 1;
//         }

//         return mask ^ n;
//     }
// }

////way  2

class Solution {
    public int bitwiseComplement(int n) {

        if(n == 0) return 1;

        int ans = 0;
        int pos = 0;

        while(n > 0){

            int bit = n & 1;      // get last bit
            int flipped = bit ^ 1; // flip bit

            ans = ans | (flipped << pos);

            pos++;

            n = n >> 1; // remove last bit
        }

        return ans;
    }
}