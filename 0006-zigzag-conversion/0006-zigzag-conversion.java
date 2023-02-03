class Solution {

    public String convert(String s, int numRows) {
        // // Way 1
        // if(numRows==1){
        //     return s;
        // }
        // char[][] arr = new char[numRows][s.length()];
        // int t = 0;
        // String ans="";
        // for (int i = 0; i < s.length(); i++) {
        //     if (i % 2 == 0 ) {
        //         for (int j = 0; j < numRows && t<s.length(); j++) {
        //             arr[j][i] = s.charAt(t);
        //             t++;
        //         }
        //     }else{
        //          for (int j = numRows-2 ; j >0 && t<s.length(); j--) {
        //             arr[j][i] = s.charAt(t);
        //              t++;
        //         }
        //     }
        // }
        // for(int i=0;i<numRows;i++){
        //     for(int j=0;j<arr[0].length;j++){
        //         if(arr[i][j]>' '){
        //             ans=ans+arr[i][j];
        //         }
        //     }
        // }
        // return ans;

        //WAY 2

        char[][] a = new char[numRows][s.length()];
        int x = -1, t = 0;
        int n = s.length();
        int i, j;
        String word = "";
        while (t != n) {
            x++;
            for (i = 0; i < numRows && t != n; i++) {
                a[i][x] = s.charAt(t++);
            }
            for (i = numRows - 2; i > 0 && t != n; i--) {
                a[i][++x] = s.charAt(t++);
            }
        }
        for (i = 0; i < numRows; i++) {
            for (j = 0; j <= x; j++) {
                if (a[i][j] != '\u0000') word += a[i][j];
            }
        }
        return word;
    }
}
