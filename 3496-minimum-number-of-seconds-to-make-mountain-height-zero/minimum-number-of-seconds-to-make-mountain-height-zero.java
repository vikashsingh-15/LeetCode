class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        int timeMax = 0;

        for (int t : workerTimes) {
            timeMax = Math.max(timeMax, t);
        }

        long left = 0;
        long right = (long) timeMax * mountainHeight * (mountainHeight + 1) / 2; //time taken by timeMax worker to reduce mountainHeight

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (canReduce(mid, mountainHeight, workerTimes)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canReduce(long midTime, int mountainHeight, int[] workerTimes) {
        long total = 0;

        //at down we have passed time (midTime) now we ask ki itna time me tum kitna height reduce lar payegha for each worker and sum it
        for (int t : workerTimes) {
            int h = calculateH(midTime, t);
            total += h;

            if (total >= mountainHeight)
                return true;
        }

        return false;
    }

    private int calculateH(long midTime, int t) {
        int h = 0;

        for (int i = 1;; i++) {
            long required = (long) t * i * (i + 1) / 2;

            if (required > midTime)
                break;

            h = i;
        }

        return h;
    }

    /**
    calculateH actually solve equation

    Time=(t*1)+(t*2)+(t*3).....(t*h)
    midTime=(t*1)+(t*2)+(t*3).....(t*h)
    midTime=t(h(h+1)/2)--> now simple  we iterate over h and see what value fits .
    
    
     */
}