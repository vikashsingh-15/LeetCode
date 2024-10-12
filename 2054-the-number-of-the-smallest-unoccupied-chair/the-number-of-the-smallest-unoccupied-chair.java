// class Solution {

//     public int smallestChair(int[][] times, int targetFriend) {
//         int n=times.length;
//         int targetArrivalTime=times[targetFriend][0];
//         int chairsFreeAt[]=new int[n];
     
//         Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));
//         for (int[] time : times) {
//             int arrival=time[0];
//             int departure=time[1];
//             for(int i=0;i<n;i++){
//                 if(chairsFreeAt[i] <= arrival){
//                     chairsFreeAt[i]=departure;
//                     if(arrival==targetArrivalTime){
//                         return i;
//                     }
//                     break;
//                 }
//             }
//         }
//         return -1;
//     }
// }

//way 2

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrivalTime=times[targetFriend][0];
        Arrays.sort(times,(a,b)-> Integer.compare (a[0],b[0]));

        PriorityQueue<int[]> occupiedChairUntill=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> minChairAvailable=new PriorityQueue<>();
        int chair=0;

        for(int i=0;i<times.length;i++){
            int arrive=times[i][0];
            int dept=times[i][1];
            while(!occupiedChairUntill.isEmpty() && occupiedChairUntill.peek()[0]<=arrive ){
                minChairAvailable.offer(occupiedChairUntill.poll()[1]);
            }//before i come all vacant chaira are placed in minChairsAvailable.

            if(minChairAvailable.isEmpty()){
                occupiedChairUntill.offer(new int[]{dept,chair});
                if(arrive==targetArrivalTime){
                    return chair;
                }else{
                    chair++;
                }
            }else{
                int leastChairAvailable=minChairAvailable.poll();
                if(arrive==targetArrivalTime){
                    return leastChairAvailable;
                }else{
                    occupiedChairUntill.offer(new int[]{dept,leastChairAvailable});
                }
            }

        }
        return -1;
    }
}