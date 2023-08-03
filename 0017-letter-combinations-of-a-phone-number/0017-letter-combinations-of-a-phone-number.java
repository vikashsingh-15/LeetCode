// class Solution {
//      static String[] map={" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
//     public List<String> letterCombinations(String str) {
//         List<String> dummy=new ArrayList<>();
//         if(str.length()==0){
//             return dummy;
//         }
//         else{
//             List<String> result=getKey(str);
//             return result;
//         }    
//     }
    
    
//     public List<String> getKey(String digits){    
//          List<String> dummy = new ArrayList<>();
//         List<String> ans = new ArrayList<>();
//         dummy.add("");

//         for (int i = 0; i < digits.length(); i++) {
//             String word = map[digits.charAt(i) - '0'];
//             int size = dummy.size();

//             for (int j = 0; j < size; j++) {
//                 for (int k = 0; k < word.length(); k++) {
//                     String temp = dummy.get(j) + word.charAt(k);
//                     dummy.add(temp);

//                     if (temp.length() == digits.length()) {
//                         ans.add(temp);
//                     }
//                 }
//             }
//         }
//         return ans;
//     }  
// }



class Solution {
     static String[] map={" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String str) {
        List<String> dummy=new ArrayList<>();
        if(str.length()==0){
            return dummy;
        }
        else{
            List<String> result=getKey(str);
            return result;
        }    
    }
      
    public List<String> getKey(String str){    
        if(str.length()==0){
    List<String> dummy=new ArrayList<>();
            dummy.add("");
            return dummy;
        }
        char ch=str.charAt(0);
        String rest=str.substring(1);
         List<String> res=getKey(rest);
         List <String>mres=new ArrayList<>();
        
        String codes=map[ch-'0'];
        for(int i=0;i<codes.length();i++){
            char charOfCodes=codes.charAt(i);
            for(String rstr:res){
                 mres.add(charOfCodes+rstr);               
             }
        }
        return mres;  
    }    
}



// class Solution {
//     public List<String> letterCombinations(String digits) {
//         if (digits.isEmpty()) return Collections.emptyList();

//         String[] phone_map = {" "," ","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//         List<String> output = new ArrayList<>();
//         backtrack("", digits, phone_map, output);
//         return output;
//     }

//     private void backtrack(String combination, String next_digits, String[] phone_map, List<String> output) {
//         if (next_digits.isEmpty()) {
//             output.add(combination);
//         } else {
//             String letters = phone_map[next_digits.charAt(0) - '0'];
//             for (char letter : letters.toCharArray()) {
//                 backtrack(combination + letter, next_digits.substring(1), phone_map, output);
//             }
//         }
//     }
// }