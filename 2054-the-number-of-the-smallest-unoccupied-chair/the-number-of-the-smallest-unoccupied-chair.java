class Solution {

    public int smallestChair(int[][] times, int targetFriend) {
        int n=times.length;
        int targetArrivalTime=times[targetFriend][0];
        int chairsFreeAt[]=new int[n];
     
        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));


        for (int[] time : times) {
            int arrival=time[0];
            int departure=time[1];
            for(int i=0;i<n;i++){
                if(chairsFreeAt[i] <= arrival){
                    chairsFreeAt[i]=departure;

                    if(arrival==targetArrivalTime){
                        return i;
                    }
                    break;
                }
            }
        }
        return -1;
    }
}