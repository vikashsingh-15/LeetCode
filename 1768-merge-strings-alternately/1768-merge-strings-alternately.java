class Solution {
    public String mergeAlternately(String word1, String word2) {
        //  StringBuilder mergedString = new StringBuilder();
        // int i = 0, j = 0;
        // while (i < word1.length() && j < word2.length()) {
        //     mergedString.append(word1.charAt(i++));
        //     mergedString.append(word2.charAt(j++));
        // }
        // mergedString.append(word1.substring(i));
        // mergedString.append(word2.substring(j));
        // return mergedString.toString();
        
        
        //way 2
        
        int apoint=0;
        int bpoint=0;
        String s="";
        
        while(apoint<word1.length()||bpoint<word2.length()){
            if(apoint<word1.length()){
                s+=word1.charAt(apoint++);
            }
            if(bpoint<word2.length()){
                s+=word2.charAt(bpoint++);
            }
        }
        
        return s;
    }
}