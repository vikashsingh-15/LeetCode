//TLE
// class Solution {
//     public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

//         int[][] grid = new int[n][11];

//         // Mark reserved seats
//         for (int[] pos : reservedSeats) {

//             int row = pos[0] - 1;
//             int seat = pos[1];

//             grid[row][seat] = -1;
//         }

//         int count = 0;

//         // Check every row
//         for (int i = 0; i < n; i++) {

//             // Group 1: seats 2,3,4,5
//             if (grid[i][2] != -1 &&
//                 grid[i][3] != -1 &&
//                 grid[i][4] != -1 &&
//                 grid[i][5] != -1) {

//                 count++;

//                 // Mark seats as occupied
//                 grid[i][2] = -1;
//                 grid[i][3] = -1;
//                 grid[i][4] = -1;
//                 grid[i][5] = -1;
//             }

//             // Group 2: seats 4,5,6,7
//             if (grid[i][4] != -1 &&
//                 grid[i][5] != -1 &&
//                 grid[i][6] != -1 &&
//                 grid[i][7] != -1) {

//                 count++;

//                 grid[i][4] = -1;
//                 grid[i][5] = -1;
//                 grid[i][6] = -1;
//                 grid[i][7] = -1;
//             }

//             // Group 3: seats 6,7,8,9
//             if (grid[i][6] != -1 &&
//                 grid[i][7] != -1 &&
//                 grid[i][8] != -1 &&
//                 grid[i][9] != -1) {

//                 count++;

//                 grid[i][6] = -1;
//                 grid[i][7] = -1;
//                 grid[i][8] = -1;
//                 grid[i][9] = -1;
//             }
//         }

//         return count;
//     }
// }

//way 2
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        HashMap<Integer, int[]> map = new HashMap<>();

        // Store only rows that have reserved seats
        for (int[] pos : reservedSeats) {

            int row = pos[0];
            int seat = pos[1];

            if (!map.containsKey(row)) {
                map.put(row, new int[11]);
            }

            map.get(row)[seat] = -1;
        }

        // Initially every row can accommodate 2 families
        int count = (n - map.size()) * 2;

        // Process only rows having reservations
        for (int[] seats : map.values()) {

            // Group 1: 2,3,4,5
            boolean left =
                    seats[2] != -1 &&
                    seats[3] != -1 &&
                    seats[4] != -1 &&
                    seats[5] != -1;

            // Group 2: 4,5,6,7
            boolean middle =
                    seats[4] != -1 &&
                    seats[5] != -1 &&
                    seats[6] != -1 &&
                    seats[7] != -1;

            // Group 3: 6,7,8,9
            boolean right =
                    seats[6] != -1 &&
                    seats[7] != -1 &&
                    seats[8] != -1 &&
                    seats[9] != -1;

            if (left && right) {
                count += 2;
            } 
            else if (left || middle || right) {
                count += 1;
            }
        }

        return count;
    }
}