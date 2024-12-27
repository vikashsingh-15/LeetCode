////TLE
// class Solution {
//     public int maxScoreSightseeingPair(int[] arr) {
//         int max=0;
//         for(int i=0;i<arr.length;i++){
//             for(int j=i+1;j<arr.length;j++){
//                 max=Math.max(max,(arr[i]+arr[j]+i-j));
//             }
//         }
//        return max; 
//     }
// }



class Solution {
    public int maxScoreSightseeingPair(int[] arr) {
        int max=0;
        int [] leftmax=new int[arr.length];
        leftmax[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            int currentright=arr[i]-i;
           max=Math.max(max,leftmax[i-1]+currentright); 
           int currentleft=arr[i]+i;
           leftmax[i]=Math.max(leftmax[i-1],currentleft);
        
        }
       return max; 
    }
}
