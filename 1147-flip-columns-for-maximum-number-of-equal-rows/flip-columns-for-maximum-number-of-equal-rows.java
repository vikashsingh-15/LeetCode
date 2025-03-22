// class Solution {
//     public int maxEqualRowsAfterFlips(int[][] mat) {
//        int total=0;
//        int max=0;
//         for(int i=0;i<mat.length;i++){
//             int same=checkSame(mat,i);
//             int inv=checkInv(mat,i);
//             total=same+inv;
//             max=Math.max(max,total);
//         }
//         return max;
//     }
//     public int checkSame(int[][]mat,int i){
//         int count=0;
//         for(int j=0;j<mat.length;j++){
//             if(Arrays.equals(mat[j],mat[i])){
//                 count++;
//             }
//         }
//         return count;
//     }

//      public int checkInv(int[][]mat,int i){
//        int[] invertedArray = Arrays.copyOf(mat[i], mat[i].length);
//         for(int k=0;k<invertedArray.length;k++){
//             invertedArray[k]^=1;// Flip 0 ↔ 1
//         }
//          int count=0;
//         for(int j=0;j<mat.length;j++){
//             if(Arrays.equals(mat[j],invertedArray)){
//                 count++;
//             }
//         }
//         return count;
//     }
// }

////way 2

class Solution {
    public int maxEqualRowsAfterFlips(int[][] mat) {
        Map<String, Integer> map = new HashMap<>();
        int maxCount = 0;

        for (int i = 0; i < mat.length; i++) {
            String normal = "";
            String inverted = "";

            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    normal += "1";
                    inverted += "0";
                } else {
                    normal += "0";
                    inverted += "1";
                }
            }
            map.put(normal, map.getOrDefault(normal, 0) + 1);
            map.put(inverted, map.getOrDefault(inverted, 0) + 1);

            maxCount = Math.max(maxCount, map.get(normal));
            maxCount = Math.max(maxCount, map.get(inverted));
            /**
             * agar koi string pattern ka inverted hai to wo ultimately aage chalke later in
             * loop noraml banke aayegha aur uska inverted dono me add hogga.
             * 
             * 1101100
             * 0010011
             * 1101100
             * 1110111
             * 0010011
             * 
             * eg -> 0010011 to iska inverted 1101100 pahele update ho chula hoga.
             * thus sum ka jarurat nahi max se kaam ho gheyha.ultimately toward the end
             * 
             * 
             * 
             */
        }

        return maxCount;
    }
}
