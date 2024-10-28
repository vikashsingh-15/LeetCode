////way 1 --> Memory Limit Exceed

// class Solution {
//     public int longestSquareStreak(int[] nums) {
//         List<List<Integer>> allSubsequences = new ArrayList<>();
//         createAllSeq(nums,0,new ArrayList<>(),allSubsequences); 
//             int maxStreak=-1;
//          for (int i = 0; i < allSubsequences.size(); i++) {
//             List<Integer> subsequence = allSubsequences.get(i);
//             int currentStreak = 1; 
//             Collections.sort(subsequence);
//             for (int j = 1; j < subsequence.size(); j++) {
//                if (subsequence.get(j) == subsequence.get(j - 1) * subsequence.get(j - 1)) {
//                     currentStreak++;
//                 } else {
//                     maxStreak = Math.max(maxStreak, currentStreak);
//                     currentStreak = 1;
//                 }
//             }
//             maxStreak = Math.max(maxStreak, currentStreak);           
           
//         }

//         return maxStreak > 1 ? maxStreak : -1;

//     }

//     public void createAllSeq(int [] arr,int index,List<Integer> current,List<List<Integer>>allSeq){
//         if(index==arr.length){
//             allSeq.add(new ArrayList<Integer>(current));
//             return;
//         }

//         current.add(arr[index]);
//         createAllSeq(arr,index+1,current,allSeq);

//         current.remove(current.size()-1);
//         createAllSeq(arr,index+1,current,allSeq);

//     }
// }


////way 2

class Solution {

    public int longestSquareStreak(int[] nums) {
        int longestStreak = 0;

        Set<Integer> uniqueNumbers = new HashSet<>();
        for (int num : nums) {
            uniqueNumbers.add(num);
        }

        for (int startNumber : nums) {
            int currentStreak = 0;
            long current = startNumber;
            while (uniqueNumbers.contains((int) current)) {
                currentStreak++;
                if (current * current > 1e5) break;

                current *= current;
            }
            longestStreak = Math.max(longestStreak, currentStreak);
        }

        return longestStreak < 2 ? -1 : longestStreak;
    }
}