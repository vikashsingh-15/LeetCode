class Solution {

    public int maxVowels(String s, int k) {
        // //TLE
        // int maxVowel = 0;
        // for (int i = 0; i <= s.length() - k; i++) {
        //     int vowelPerWindow = 0;
        //     for (int j = i; j < i + k; j++) {
        //         if ("aeiouAEIOU".contains(String.valueOf(s.charAt(j)))) vowelPerWindow++;
        //     }
        //     maxVowel = Math.max(maxVowel, vowelPerWindow);
        // }
        // return maxVowel;
        
         int max_vow = 0, cur_vow=0;
        for(int i=0;i<s.length();i++){
            cur_vow += isVowel(s.charAt(i));
            if(i>=k)
                cur_vow -= isVowel(s.charAt(i-k));
            max_vow = Math.max(max_vow, cur_vow);
        }
        return max_vow;    
    }
    
    public int isVowel(char c){
        if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u')
            return 1;
        return 0;
    }
}
