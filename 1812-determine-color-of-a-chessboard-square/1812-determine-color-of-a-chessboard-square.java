class Solution {
    public boolean squareIsWhite(String coordinates) {
        int x=coordinates.charAt(0)-'a';
        int y=coordinates.charAt(1)-'0';
        if(x%2==0){
            if(y%2==0){
                return true;
            }else{
                return false;
            }
            
        }
        else{
             if(y%2!=0){
                return true;
            }else{
                return false;
            }
            
        }
        
        
    }
}