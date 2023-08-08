class Solution {
    public int characterReplacement(String s, int k) {
            int maxFreq=0;
        Map<Character, Integer>map=new HashMap <>();
            int bpoint=0;
        for(int apoint=0;apoint<s.length();apoint++){
            char currChar=s.charAt(apoint);
            map.put(currChar,map.getOrDefault(currChar,0)+1);
            maxFreq=Math.max(maxFreq,map.get(currChar));
            
            while(apoint-bpoint+1>k+maxFreq){
                map.put(s.charAt(bpoint),map.get(s.charAt(bpoint))-1);
                bpoint++;
            }
            
        }
        return s.length()-bpoint;
    }
}