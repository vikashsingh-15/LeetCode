class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Integer.MIN_VALUE;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
             // System.out.print("Left = "+left);
             // System.out.print(" Right = "+right);
             // System.out.print(" Mid = "+mid);
             // System.out.println();
            
            if (canEatAll(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean canEatAll(int[] piles, int h, int k) {
        int hours = 0;
        for (int i = 0; i < piles.length; i++) {
            hours += (int) Math.ceil((double) piles[i] / k);
            // System.out.print(" piles[i]= "+piles[i] );
            // System.out.print(" piles[i] / k = "+ (int) Math.ceil((double) piles[i] / k) );
            // System.out.println();
        }
        
        // System.out.println(" hour = "+hours);
        // System.out.println();     

        return hours <= h;
    }
}
