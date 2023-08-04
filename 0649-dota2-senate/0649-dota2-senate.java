class Solution {
    public String predictPartyVictory(String senate) {
     Queue<Integer> radi=new LinkedList<>();
      Queue<Integer> dire=new LinkedList<>();
      int n = senate.length();
      for(int i=0;i<senate.length();i++){
          if(senate.charAt(i)=='R') radi.add(i);
          else dire.add(i);
      }
        int count=0;
        while(!radi.isEmpty() && !dire.isEmpty()){
            int d=dire.poll();
            int r=radi.poll();
            if(r<d){
                radi.add(r+n);
            }else{
                dire.add(d+n);
            }
            
        }
        return radi.size() > dire.size() ? "Radiant" : "Dire";
    }   
}