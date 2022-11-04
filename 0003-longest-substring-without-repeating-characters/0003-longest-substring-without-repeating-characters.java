class Solution {

    public int lengthOfLongestSubstring(String str) {
        ////Way 1
        //         int apoint=0;
        //         int bpoint=0;
        //         int max=0;
        //         HashMap<Character,Integer>map=new HashMap<>();

        //         while(bpoint<=str.length()-1){
        //             char c=str.charAt(bpoint);
        //             bpoint++;
        //             map.put(c,map.getOrDefault(c,0)+1);
        //             if(map.get(c)==1){
        //                 max=Math.max(max,map.size());
        //             }else{
        //                 while(str.charAt(apoint)!=c){
        //                     map.remove(str.charAt(apoint));
        //                     apoint++;

        //                 }

        //                 map.put(str.charAt(apoint),map.get(str.charAt(apoint))-1);
        //                     apoint++;
        //             }
        //         }

        //        return max;

        ////way 2
        int apoint = 0;
        int bpoint = 0;
        int max = 0;

        int[] arrChar = new int[128];

        while (bpoint < str.length()) {
            char c = str.charAt(bpoint);
            bpoint++;

            arrChar[c]++;

            while (arrChar[c] > 1) {
                arrChar[str.charAt(apoint++)]--;
            }
            
            max = Math.max(max , bpoint - apoint );
        }
        return max;
    }
}
