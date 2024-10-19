// class Solution {
//     public char findKthBit(int n, int k) {
       
//        String ans="0";

//         for(int i=1;i<n;i++){
//             String temp=helper(ans);
//             ans=ans+"1"+temp;
//         }

//         return ans.charAt(k-1);
        
//     }

//     public String helper(String str){
//         StringBuilder sb=new StringBuilder(str);
//         for (int i = 0; i < sb.length(); i++) {
//             char currentChar = sb.charAt(i);
//             if (currentChar == '0') {
//                 sb.setCharAt(i, '1');
//             }
//             else if (currentChar == '1') {
//                 sb.setCharAt(i, '0');
//             }
//         }

//         return sb.reverse().toString();
//     }
// }


//way 2


class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) return '0';
        int len = 1 << n; 
        if (k < len / 2) {
            return findKthBit(n - 1, k);
        }
        
        else if (k == len / 2) {
            return '1';
        }
       
        else {
            char correspondingBit = findKthBit(n - 1, len - k);
            return (correspondingBit == '0') ? '1' : '0'; 
    }
    }
}