class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder("");
        for(int i=0;i<word.length();){
            char c =word.charAt(i);
            int conse=0;
            while(i<word.length() && conse<9 && word.charAt(i)==c){
                conse++;
                i++;
            }
            comp.append(conse).append(c);
        }
        return comp.toString();
    }
}