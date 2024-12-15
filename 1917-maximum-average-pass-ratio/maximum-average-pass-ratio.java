////TLE
// class Solution {
//     public double maxAverageRatio(int[][] arr, int ext) {
//         int n = arr.length;
//         double[] pr = new double[n];

//         for (int i = 0; i < arr.length; i++) {
//             pr[i] = (double) arr[i][0] / arr[i][1];
//         }

//         while (ext-- > 0) {
//             int index = 0;
//             double maxGain = -1;

//             for (int i = 0; i < arr.length; i++) {
//                 double currentPr = (double) arr[i][0] / arr[i][1];
//                 double newPr = (double) (arr[i][0] + 1) / (arr[i][1] + 1);
//                 double gain = newPr - currentPr;

//                 if (gain > maxGain) {
//                     maxGain = gain;
//                     index = i;
//                 }
//             }
//             arr[index][0]++;
//             arr[index][1]++;
//             pr[index] = (double) arr[index][0] / arr[index][1];
//         }


//     double ans=0.0;

//     for(int i = 0;i<pr.length;i++)
//     {
//         ans += pr[i];
//     }
// return ans/n;
// }}

class Solution {
    public double maxAverageRatio(int[][] arr, int ext) {
       int n = arr.length;
       PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) ->Double.compare(b[0], a[0]));

        for (int i = 0; i < arr.length; i++) {
           int passes = arr[i][0], total = arr[i][1];
           double currentRatio = (double) passes / total;
           double gain = ((double) (passes + 1) / (total + 1)) - currentRatio;
            pq.offer(new double[]{gain, passes, total});
        }

        while (ext-- > 0) {
            double top[]=pq.poll();
            int pass=(int) top[1];
            int total=(int) top[2];
            pass++;
            total++;

            double newGain=((double) (pass+1)/(total+1))-((double)pass/total);
            pq.offer(new double[]{newGain,pass,total});
        }


    double totalRatio = 0.0;
        while (!pq.isEmpty()) {
            double[] top = pq.poll();
            totalRatio += (double) top[1] / top[2];
        }

        return totalRatio / n;

   
}
}

