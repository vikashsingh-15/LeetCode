class Solution {

    public int maxConsecutiveAnswers(String answerKey, int k) {
               int maxFreq = 0;
                int i = 0;
                Map<Character, Integer> charCount = new HashMap<>();

                for (int j = 0; j < answerKey.length(); j++) {
                    char currentChar = answerKey.charAt(j);
                    charCount.put(currentChar, charCount.getOrDefault(currentChar, 0) + 1);
                    maxFreq = Math.max(maxFreq, charCount.get(currentChar));

                    while (j - i + 1 > maxFreq + k) {
                        charCount.put(answerKey.charAt(i), charCount.get(answerKey.charAt(i)) - 1);
                        i++;
                    }
                }

                return answerKey.length() - i;
    }
}
    
    
//     public int maxConsecutiveAnswers(String answerKey, int k) {
//        return Math.max(Helper(answerKey,k,'T'),Helper(answerKey,k,'F'));

//     }
    
//     public int Helper(String answerKey,int k,char ch){
//          int apoint=0;
//         int bpoint=0;
//         int ans=0;   
//         for( apoint=0;apoint<answerKey.length();apoint++){
//             char curr=answerKey.charAt(apoint);   
//             if(curr==ch){
             
//             }
//             if(curr!=ch){
//                 k--;
//             }
//             while(k<0){
//                 if(answerKey.charAt(bpoint)==ch){
//                      bpoint++;
//                 }else{
//                     k++;
//                     bpoint++;
//                 }  
//             }
//                ans=Math.max(ans,apoint-bpoint+1);
            
            
//         }
//         return ans;
//     }
// }
