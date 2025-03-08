// class Solution {
//     public int minimumRecolors(String str, int k) {

//         int left = 0;
//         int numWhite = 0;
//         int numRecol = Integer.MAX_VALUE;

//         for (int right = 0; right < str.length(); right++) {
//             if (str.charAt(right) == 'W') {
//                 numWhite++;
//             }

//             if (right - left + 1 == k) {
//                 numRecol = Math.min(numWhite, numRecol);
//                 if (str.charAt(left) == 'W') {
//                     numWhite--;
//                 }
//                 left++;
//             }

//         }
//         return numRecol;
//     }
// }

////way  2

class Solution {
    public int minimumRecolors(String str, int k) {
        Queue<Character> queue = new LinkedList<>();
        int left = 0;
        int numWhite = 0;

        for (int i = 0; i < k; i++) {
            queue.add(str.charAt(i));
            if (str.charAt(i) == 'W') {
                numWhite++;
            }
        }

        int numRecolors=numWhite;

        for(int i=k;i<str.length();i++){
            char c=str.charAt(i);
            if(c=='W'){
                numWhite++;
            }
            if(queue.poll()=='W'){
                numWhite--;
            }
            queue.add(c);

            numRecolors = Math.min(numRecolors, numWhite);
        }

        return numRecolors;
    }
}