class Solution {
    public int minOperations(String s) {
        int c=0,d=0;
           for(int i=0;i<s.length();i++){
               if(s.charAt(i)=='0' && i%2!=0) c++;
               else if(s.charAt(i)=='1' && i%2!=1) c++;
           }
           
           for(int i=0;i<s.length();i++){
               if(s.charAt(i)=='1' && i%2!=0) d++;
               else if(s.charAt(i)=='0' && i%2!=1) d++;
           }
              return Math.min(c,d);
    }
}