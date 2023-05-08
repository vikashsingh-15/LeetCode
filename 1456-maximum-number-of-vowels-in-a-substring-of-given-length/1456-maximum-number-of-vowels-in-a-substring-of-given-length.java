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


        int max_vow = 0,setCount = 0;        
        for(int i=0;i<s.length();i++){
            if (isVowel(s.charAt(i))) {
                setCount++;
            }
            if (i >= k) {
                if (isVowel(s.charAt(i - k))) {
                    setCount--;
                }
            }
             max_vow = Math.max(max_vow, setCount);
        
        }
        return max_vow;
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
}
