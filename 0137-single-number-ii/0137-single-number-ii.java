class Solution {
    public int singleNumber(int[] nums) {
           int seenOnce = 0;
        int seenTwice = 0;
        
        for(int num: nums) {
            System.out.println();
            // System.out.print("Checking for = "+num);
            // System.out.print(" Seen once ="+seenOnce);
            // System.out.print(" Seen Twics ="+seenTwice);
            // System.out.print(" ~seenTwice & (seenOnce ^ num) ="+ (~seenTwice & (seenOnce ^ num)));      
            seenOnce = ~seenTwice & (seenOnce ^ num);
            seenTwice = ~seenOnce & (seenTwice ^ num);
        }
        
        return seenOnce;
    }
}