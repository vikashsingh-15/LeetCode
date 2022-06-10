class Solution {
    public int lengthOfLongestSubstring(String str) {
        
        int apoint=0;
        int bpoint=0;
        int max=0;
        HashMap <Character,Integer> map=new HashMap<>();
        while(bpoint<str.length()){
            
            char c=str.charAt(bpoint);
            bpoint++;
            map.put(c,map.getOrDefault(c,0)+1);
            if(map.get(c)==1){
                max=Math.max(max,map.size());
            }
            
            if(map.get(c)==2){
                while(str.charAt(apoint)!=c){
                    map.remove(str.charAt(apoint));
                    apoint++;
                    
                }
                
                map.put(str.charAt(apoint),map.get(str.charAt(apoint))-1);
                    apoint++;
            }
            
        }
        
        return max;
    }
}