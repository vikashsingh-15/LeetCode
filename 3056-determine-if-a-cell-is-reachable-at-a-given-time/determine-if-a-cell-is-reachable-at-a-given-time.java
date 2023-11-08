// class Solution {
//     public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
//         int minStep = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
//         if(minStep==0){
//            if (t == 1) {
//                 return false;
//             }else{
//                 return true;
//             }
//         }

//         return minStep <= t;
//     }
// }


class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy) {
            if (t == 1) {
                return false;
            }
        }

        int diffX=Math.abs(sx - fx);
        int diffY=Math.abs(sy - fy);

        int maxDiff = Math.max(diffX, diffY);
        if(maxDiff<=t){
            return true;
        }
        return false;
    }
}