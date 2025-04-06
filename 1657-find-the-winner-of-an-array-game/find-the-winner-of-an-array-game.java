// class Solution {
//     public int getWinner(int[] arr, int k) {
//         int maxElement=arr[0];
//         Queue<Integer> queue=new LinkedList<>();
//         for(int i=1;i<arr.length;i++){
//             maxElement=Math.max(maxElement,arr[i]);
//             queue.offer(arr[i]);
//         }

//         int curr=arr[0];
//         int winStreak=0;

//         while(!queue.isEmpty()){
//             int opponent=queue.poll();

//             if(curr>opponent){
//                 queue.offer(opponent);
//                 winStreak++;
//             }else{
//                 queue.offer(curr);
//                 curr=opponent;
//                 winStreak=1;
//             }
//            if (winStreak == k || curr == maxElement) {
//                 return curr;
//             }
//         }
        
//         return -1;

//     }
// }



// class Solution {
//     public int getWinner(int[] arr, int k) {
//          int maxElement = arr[0];
//         for (int i = 1; i < arr.length; i++) {
//             maxElement = Math.max(maxElement, arr[i]);
//         }
        
//         int curr = arr[0];
//         int winstreak = 0;
        
//         for (int i = 1; i < arr.length; i++) {
//             int opponent = arr[i];
            
//             if (curr > opponent) {
//                 winstreak++;
//             } else {
//                 curr = opponent;
//                 winstreak = 1;
//             }
            
//             if (winstreak == k || curr == maxElement) {
//                 return curr;
//             }
//         }
        
//         return -1;
//     }
// }



////way 3

class Solution {
    public int getWinner(int[] arr, int k) {
        int maxNum=Integer.MIN_VALUE;
        int index=-1;
        for(int i=0;i<arr.length;i++){
           if(arr[i]>maxNum){
            maxNum=arr[i];
            index=i;
           }
        }

        if(k>index){
            return maxNum;
        }

        int curr = arr[0];
        int winstreak = 0;
        
        for (int i = 1; i < arr.length; i++) {
            int opponent = arr[i];
            
            if (curr > opponent) {
                winstreak++;
            } else {
                curr = opponent;
                winstreak = 1;
            }
            
            if (winstreak == k || curr == maxNum) {
                return curr;
            }
        }
        
        return -1;
        
    }
}