//way 1TLE

// class Solution {
//     int m = 1;

//     public int stoneGameII(int[] piles) {


//         // Map<Integer, Integer> memo = new HashMap<>();

//         int total = 0;
//         for(int i=0;i<piles.length;i++){
//             total+=piles[i];
//         }
//         int difference = solve(piles, 0, 1);

//         return (total + difference) / 2;       
//     }

//     public int solve(int[] piles, int i, int M) {
//         if (i >= piles.length) {
//             return 0;
//         }
//         int maxDiff = Integer.MIN_VALUE;
//         int stonesTaken = 0;

//         for (int X = 1; X <= 2 * M && i + X <= piles.length; X++) {

//             stonesTaken += piles[i + X - 1];

//             int current = stonesTaken - solve(piles, i + X, Math.max(M, X));

//             maxDiff = Math.max(maxDiff, current);
//         }

//         return maxDiff;

//     }
// }

//way 2memo

import java.util.*;

class Solution {

    public int stoneGameII(int[] piles) {

        Map<Integer, Integer> memo = new HashMap<>();

        int total = Arrays.stream(piles).sum();

        int difference = solve(piles, 0, 1, memo);

        return (total + difference) / 2;
    }

    private int solve(
            int[] piles,
            int i,
            int M,
            Map<Integer, Integer> memo) {

        if (i >= piles.length) {
            return 0;
        }

        int key = i * 101 + M;

        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int maxDiff = Integer.MIN_VALUE;

        int stonesTaken = 0;

        for (int X = 1;
             X <= 2 * M && i + X <= piles.length;
             X++) {

            stonesTaken += piles[i + X - 1];

            int current =
                    stonesTaken
                    - solve(
                        piles,
                        i + X,
                        Math.max(M, X),
                        memo
                    );

            maxDiff = Math.max(maxDiff, current);
        }

        memo.put(key, maxDiff);

        return maxDiff;
    }
}