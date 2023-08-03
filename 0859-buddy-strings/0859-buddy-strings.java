class Solution {
    public boolean buddyStrings(String s, String goal) {
         if(s.length()!=goal.length()) return false;
        if(s.equals(goal)){
            int [] count = new int[26];
            int c;
            for(int i = 0;i<s.length();i++){
                c = s.charAt(i)-'a';
                count[c]++;
                if(count[c]==2)return true;
            }
            return false;
        }
        
          List<Character> diffS = new ArrayList<>();
        List<Character> diffGoal = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                 diffS.add(s.charAt(i));
                diffGoal.add(goal.charAt(i));
            }
        }
        
        return diffS.size()==2 && diffS.get(0)==diffGoal.get(1) && diffS.get(1)==diffGoal.get(0) ;

      //  return diffS.size() == 2 && s.charAt(diffS.get(0)) == goal.charAt(diffGoal.get(1)) &&       s.charAt(diffS.get(1)) == goal.charAt(diffGoal.get(0));
    }
}