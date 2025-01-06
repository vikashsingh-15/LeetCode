// class Solution {
//     public int[] minOperations(String str) {
//         int[] ans = new int[str.length()];

//         for(int i=0;i<str.length();i++){
//             int count=0;
//             for(int j=0;j<str.length();j++){
//                 if(i==j){

//                 }if(str.charAt(j)=='1'){
//                     count+=Math.abs(j-i);
//                 }

//             }
//             ans[i]=count;
//         }
//         return ans;
//     }
// }



//way 2
class Solution {
    public int[] minOperations(String str) {
         int n = str.length();
        int[] answer = new int[n];
        int count = 0;
        int operation=0;
        for(int i=0;i<n;i++){//left to right
            answer[i] += operation;
            count+=str.charAt(i)=='1'?1:0;
            operation+=count;
        }
       

         count = 0;
         operation=0;
        for(int i=n-1;i>=0;i--){//right to left
            answer[i] += operation;
            count+=str.charAt(i)=='1'?1:0;
            operation+=count;
        }

        return answer;
    }
}