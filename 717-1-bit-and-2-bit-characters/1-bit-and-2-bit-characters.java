class Solution {
    public boolean isOneBitCharacter(int[] bits) {
       int i=0;
       for(i=0;i<bits.length-1;i++){
            if(bits[i]==0){
                //
            }else{
                i++;
            }
        }

        return (i==bits.length-1);
        
    }
}