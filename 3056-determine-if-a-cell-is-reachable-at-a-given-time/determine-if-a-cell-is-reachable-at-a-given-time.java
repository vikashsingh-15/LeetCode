class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int minStep = Math.max(Math.abs(sx - fx), Math.abs(sy - fy));
        if(minStep==0){
           if (t == 1) {
                return false;
            }else{
                return true;
            }
        }

        return minStep <= t;
    }
}