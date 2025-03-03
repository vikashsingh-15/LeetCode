////not a vlaid solution see ex "()))((" ans should be 4 but this approach give 0.

// class Solution {
//     public int minAddToMakeValid(String s) {
//         int open=0;
//         int minAdd=0;
//         int close=0;
//         for(char c : s.toCharArray()){
//             if(c=='('){
//                 open++;
//             }else{
//                 close++;
//             }
//         }
//         return Math.abs(open-close);
//     }
// }


////way 2

class Solution {
    public int minAddToMakeValid(String s) {
        int open=0;
        int minAdd=0;
        int close=0;
        for(char c : s.toCharArray()){
            if(c=='('){
                open++;
            }else{
                if(open>0){
                    open--;
                }else{
                    minAdd++;
                }
            }
        }
        return open+minAdd;
    }
}