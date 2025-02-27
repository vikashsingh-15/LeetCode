class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length;
        HashSet<Integer>set=new HashSet<>();
        for(int num:arr){
            set.add(num);
        }
        int maxLength=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int prev=arr[j];
                int expected=arr[i]+arr[j];
                int currLength=2;

                while(set.contains(expected)){
                    int temp=prev;
                    prev=expected;
                    expected=temp+prev;
                    currLength++;
                    maxLength=Math.max(currLength,maxLength);
                }
            }
        }

        return maxLength;
    }
}

////way 2 --> memory Limit Exceed

// class Solution {
//     int maxLength = 0;

//     public int lenLongestFibSubseq(int[] arr) {
//         List<List<Integer>> allSubsequence = new ArrayList<>();
//         generateSubsequences(arr, 0, new ArrayList<>(), allSubsequence);
        
//         for (List<Integer> seq : allSubsequence) {
//             if (seq.size() >= 3 && isFibonacci(seq)) {
//                 maxLength = Math.max(maxLength, seq.size());
//             }
//         }

//         return maxLength;
//     }

//     private void generateSubsequences(int[] arr, int index, List<Integer> current, List<List<Integer>> allList) {
//         if (index >= arr.length) {
//             allList.add(new ArrayList<>(current));
//             return;
//         }

//         current.add(arr[index]);
//         generateSubsequences(arr, index + 1, current, allList);
//         current.remove(current.size() - 1);
//         generateSubsequences(arr, index + 1, current, allList);
//     }

//     private boolean isFibonacci(List<Integer> seq) {
//         for (int i = 2; i < seq.size(); i++) {
//             if (seq.get(i - 2) + seq.get(i - 1) != seq.get(i)) {
//                 return false; 
//             }
//         }
//         return true;
//     }
// }


////way 3--TLE

// class Solution {
//     private int maxLen = 0;

//     public int lenLongestFibSubseq(int[] arr) {
//         List<Integer> currentSeq = new ArrayList<>();
//         backtrack(arr, 0, currentSeq);
//         return maxLen >= 3 ? maxLen : 0; 
//     }

//     private void backtrack(int[] arr, int index, List<Integer> currentSeq) {
//         if (currentSeq.size() >= 3 && !isFibonacci(currentSeq)) {
//             return; 
//         }else{
//         maxLen = Math.max(maxLen, currentSeq.size()); 
//         }

//         for (int i = index; i < arr.length; i++) {
//             currentSeq.add(arr[i]); 
//             backtrack(arr, i + 1, currentSeq); 
//             currentSeq.remove(currentSeq.size() - 1); 
//         }
//     }

//     private boolean isFibonacci(List<Integer> seq) {
//         for (int i = 2; i < seq.size(); i++) {
//             if (seq.get(i - 2) + seq.get(i - 1) != seq.get(i)) {
//                 return false; 
//             }
//         }
//         return true;
//     }
// }
