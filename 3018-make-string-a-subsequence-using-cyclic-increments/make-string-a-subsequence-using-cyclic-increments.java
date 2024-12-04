class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int index2=0;
        int len1=str1.length();
        int len2=str2.length();

        for(int index1=0;index1<len1 && index2<len2;index1++){
            if(str1.charAt(index1)==str2.charAt(index2) ||str1.charAt(index1)+1==str2.charAt(index2) || str1.charAt(index1)-25==str2.charAt(index2) ){
            index2++;
        }
        }

        return index2==len2;
    }
}