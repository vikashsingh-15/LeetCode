class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        int k=0;
        int count=0;
        for(int i=0;i<t.length();i++){
            char c1=t.charAt(i);
            char c2=s.charAt(k);
            if(c1==c2){
                k++;
                count ++;
            } 
           if(count ==s.length()){
            return true;
        }
        }
        
       return false;
        
    }
}