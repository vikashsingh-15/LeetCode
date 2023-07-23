class Solution {
    public String reverseWords(String s) {
        String words[]= s.split(" +");
        String ans="";
        for(String word : words){
            ans=word+" "+ans;
            // ans=ans +" ";
        }
        
        ans=ans.trim();
        return ans;
    }
}