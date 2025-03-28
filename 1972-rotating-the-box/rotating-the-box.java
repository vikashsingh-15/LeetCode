////way 1-> First move toward right and then transpose
// class Solution {
//     public char[][] rotateTheBox(char[][] boxGrid) {
//         int m = boxGrid.length, n = boxGrid[0].length;
//         char[][] rotatedBox = new char[n][m];

//         for (int i = 0; i < m; i++) {
//             int emptySpot = n - 1; 
//             for (int j = n - 1; j >= 0; j--) {
//                 if (boxGrid[i][j] == '#') {
//                     boxGrid[i][j] = '.';
//                     boxGrid[i][emptySpot] = '#';
//                     emptySpot--;
//                 } else if (boxGrid[i][j] == '*') {
                   
//                     emptySpot = j - 1;
//                 }
//             }
//         }

//         // Step 2: Rotate 90 degrees clockwise
//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 rotatedBox[j][m - i - 1] = boxGrid[i][j];
//             }
//         }

//         return rotatedBox;
//     }
// }

//way 2 -> first transpose then move down

class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length, n = boxGrid[0].length;
        char[][] rotatedBox = new char[n][m];
        // Step 1: Rotate 90 degrees clockwise
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotatedBox[j][m - i - 1] = boxGrid[i][j];
            }
        }


        for(int i=0;i<rotatedBox[0].length;i++){
            int emptyBox=rotatedBox.length-1;
            for(int j=rotatedBox.length-1;j>=0;j--){
                if(rotatedBox[j][i]=='*'){
                    emptyBox=j-1;
                }
                if(rotatedBox[j][i]=='.'){
                    
                }
                else if(rotatedBox[j][i]=='#'){
                    rotatedBox[j][i]='.';
                    rotatedBox[emptyBox][i]='#';
                    emptyBox--;
                }
            }

        }

        return rotatedBox;
    }
}