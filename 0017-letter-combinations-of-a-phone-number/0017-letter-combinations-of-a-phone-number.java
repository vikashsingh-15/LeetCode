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
    
    
    public List<String> getKey(String digits){    
         List<String> dummy = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        dummy.add("");

        for (int i = 0; i < digits.length(); i++) {
            String word = map[digits.charAt(i) - '0'];
            int size = dummy.size();

            for (int j = 0; j < size; j++) {
                for (int k = 0; k < word.length(); k++) {
                    String temp = dummy.get(j) + word.charAt(k);
                    dummy.add(temp);

                    if (temp.length() == digits.length()) {
                        ans.add(temp);
                    }
                }
            }
        }
        return ans;
    }  
}