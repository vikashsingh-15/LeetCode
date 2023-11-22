class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int count = 0;

        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> row = nums.get(i);

            for (int j = 0; j < row.size(); j++) {
                int idx = i + j;

                if (lists.size() < idx + 1) {
                    lists.add(new ArrayList<>());
                }
                lists.get(idx).add(row.get(j));
                
                count ++;
            }
        }

        int[] res = new int[count];
        int idx = 0;
        for (List<Integer> list : lists) {
            for (int i = list.size() - 1; i >= 0; i--) {
                res[idx++] = list.get(i); 
            }
        }
        return res;
    }
}

// import java.util.ArrayList;
// import java.util.List;

// class Solution {
//     public int[] findDiagonalOrder(List<List<Integer>> nums) {
//         if (nums == null || nums.size() == 0) {
//             return new int[0];
//         }

//         List<Integer> list = new ArrayList<>();

//         for (int i = 0; i < nums.size(); i++) {
//              int valI = i;
//             for (int j = 0; j < i + 1; j++) {
//                     List<Integer> row = nums.get(valI);
//                     if (j < row.size()) {
//                         int data = row.get(j);
//                         list.add(data);
//                     }
//                     valI--;
//             }
//         }





//         int[] resultArray = new int[list.size()];
//         for (int i = 0; i < list.size(); i++) {
//             resultArray[i] = list.get(i);
//         }

//         return resultArray;
//     }
// }
