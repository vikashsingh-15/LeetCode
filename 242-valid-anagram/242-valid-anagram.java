class Solution {
    public boolean isAnagram(String s, String t) {
        
        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        
        for(int i=0;i<s.length();i++){
            char c =s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        } 
        // System.out.println(map);
        for(int i=0;i<t.length();i++){
            char c =t.charAt(i);
            map.put(c,map.getOrDefault(c,0)-1);
            if(map.get(c)==0){
                map.remove(c);
            }
        } 
        // System.out.println(map); 
        if(map.size()==0){
            return true;
        }
        else{
            return false;
        }
        
        
//         way 2
        
//         int[] alphabet = new int[26];
//         for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;
//         for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;
//         for (int i : alphabet) if (i != 0) return false;
//         return true;
        
        
    }
}