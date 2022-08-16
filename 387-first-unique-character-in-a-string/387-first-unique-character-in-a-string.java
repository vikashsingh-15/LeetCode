class Solution {
    public int firstUniqChar(String s) {
//         HashMap<Character,Integer> map=new HashMap<>();
//         int ans=-1;
//         for(int i=0;i<s.length();i++){
//             char c=s.charAt(i);
//             map.put(c,map.getOrDefault(c,0)+1);
//         }
        
//         for(int i=0;i<s.length();i++){
//             char c=s.charAt(i);
//             int val=map.get(c);
//             if(val<2){
//                 ans=i;
//                 break;
//             }
//         }
//         return ans;
        
        
        
        

        int ans = Integer.MAX_VALUE;
        for(char c='a'; c<='z';c++){
            int index = s.indexOf(c);//default value of s.indexOf(c);=-1
            // System.out.println(index);
            if(index!=-1&&index==s.lastIndexOf(c)){
                ans = Math.min(ans,index);
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
        
    }
}