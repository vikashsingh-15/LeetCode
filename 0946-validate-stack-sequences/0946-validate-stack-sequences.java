class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
       
        Stack <Integer> st=new Stack<>();
        int bpoint=0;
        
       for(int value:pushed){
           st.push(value);
           
           while(st.size()>0 && st.peek() == popped[bpoint] ){
               st.pop();
               bpoint++;
           }
       }
        
        return st.isEmpty();
    }
}