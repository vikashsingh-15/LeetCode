class Solution {

    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        char[][] arr = new char[numRows][s.length()];
        int t = 0;
        String ans="";
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0 ) {
                for (int j = 0; j < numRows && t<s.length(); j++) {
                    arr[j][i] = s.charAt(t);
                    t++;
                }
            }else{
                 for (int j = numRows-2 ; j >0 && t<s.length(); j--) {
                    arr[j][i] = s.charAt(t);
                     t++;
                }
            }
        }
        
        for(int i=0;i<numRows;i++){
            for(int j=0;j<arr[0].length;j++){
                if(arr[i][j]>' '){
                    ans=ans+arr[i][j];
                }
            }
        }
        return ans;
    }
}
