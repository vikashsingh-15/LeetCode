//wrong approach fails for --> [1,2,0,2,3,0,1] 
// class Solution {
//     public int[] avoidFlood(int[] rains) {
//         int ans[]=new int[rains.length];

//         TreeSet<Integer>set=new TreeSet<>();
//         Queue<Integer>queue=new LinkedList<>();
//         int dryDay=0;
//         for(int i=0;i<rains.length;i++){
//             if(rains[i]==0){
//                 dryDay++;
//                 if(queue.size()>0){ans[i]=queue.poll();}
//                 else{
//                     ans[i]=1;
//                 }
//             }
//             else{
//                if( set.contains(rains[i])){
//                     if(dryDay>0){
//                         dryDay--;
//                         ans[i]=-1;
//                     }else{
//                         return new int[0];
//                     }

//                 }else{
//                     set.add(rains[i]);
//                     ans[i]=-1;
//                     queue.add(rains[i]);
//                 }
//             }

//         }
//        return ans; 
//     }
// }


import java.util.*;

// class Solution {
//     public int[] avoidFlood(int[] rains) {
//         int n = rains.length;
//         int[] ans = new int[n];
//         Map<Integer, Integer> full = new HashMap<>();
//         TreeSet<Integer> dryDays = new TreeSet<>();

//         for (int i = 0; i < n; i++) {
//             if (rains[i] == 0) {
//                 dryDays.add(i);
//                 ans[i] = 1;
//             } else {
//                 int lake = rains[i];
//                 ans[i] = -1;
//                 if (full.containsKey(lake)) {   
//                     Integer dryDay = dryDays.higher(full.get(lake));
//                     // at this point dryDay s greted then previous lake day and smaller than new lake
//                     if (dryDay == null) {
//                         return new int[0];
//                     }
//                     ans[dryDay] = lake;
//                     dryDays.remove(dryDay);
//                 }
//                 full.put(lake, i);
//             }
//         }

//         return ans;
//     }
// }

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Map<Integer, Integer> full = new HashMap<>();
        List<Integer> dryDays = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1;
            } else {
                int lake = rains[i];
                ans[i] = -1;

                if (full.containsKey(lake)) {
                    int lastRainDay = full.get(lake);
                    Integer dryDay = null;

                    // \U0001f50d Manually find the next dry day after lastRainDay
                    for (int j = 0; j < dryDays.size(); j++) {
                        if (dryDays.get(j) > lastRainDay) {
                            dryDay = dryDays.get(j);
                            dryDays.remove(j);
                            break;
                        }
                    }

                    if (dryDay == null) {
                        return new int[0]; // flood unavoidable
                    }

                    ans[dryDay] = lake; // assign this dry day to dry the lake
                }

                full.put(lake, i);
            }
        }

        return ans;
    }
}
