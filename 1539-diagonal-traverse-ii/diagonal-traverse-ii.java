class Solution {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> diagonalMap = new HashMap<>();
        int totalElement = 0;
        for (int i = nums.size()-1; i >=0; i--) {
            List<Integer> row = nums.get(i);
            for (int j = 0; j < row.size(); j++) {
                int value = row.get(j);
                int key = i + j;
                diagonalMap.putIfAbsent(key, new ArrayList<>());
                diagonalMap.get(key).add(value);
                totalElement++;
                
            }
        }

        int[] ans = new int[totalElement];
        int i = 0;
        int curr = 0;

        while (diagonalMap.containsKey(curr)) {
            for (int num : diagonalMap.get(curr)) {
                ans[i] = num;
                i++;
            }
            curr++;
        }

        return ans;
    }
}
// class Solution {
//     public int[] findDiagonalOrder(List<List<Integer>> nums) {
//         int count = 0;
//         List<List<Integer>> lists = new ArrayList<>();
//         for (int i = 0; i < nums.size(); i++) {
//             List<Integer> row = nums.get(i);
//             for (int j = 0; j < row.size(); j++) {
//                 int idx = i + j;
//                 if (lists.size() < idx + 1) {
//                     lists.add(new ArrayList<>());
//                 }
//                 lists.get(idx).add(row.get(j));
//                 count ++;
//             }
//         }
//         int[] res = new int[count];
//         int idx = 0;
//         for (List<Integer> list : lists) {
//             for (int i = list.size() - 1; i >= 0; i--) {
//                 res[idx++] = list.get(i);
//             }
//         }
//         return res;
//     }
// }
////fail at test case 53/54
// class Solution {
//     public int[] findDiagonalOrder(List<List<Integer>> nums) {
//         Map<Integer, List<Integer>> diagonalMap = new HashMap<>();
//         int totalElement = 0;
//         for (int i = 0; i < nums.size(); i++) {
//             List<Integer> row = nums.get(i);
//             // totalElement += row.size();
//             for (int j = 0; j < row.size(); j++) {
//                 int value = row.get(j);
//                 int key = i + j;
//                 diagonalMap.putIfAbsent(key, new ArrayList<>());
//                 diagonalMap.get(key).add(value);
//                 totalElement++;
//                 // if (map.containsKey(key)) {
//                 //     map.put(key, new ArrayList<>());
//                 // } else {
//                 //     map.get(key).add(value);
//                 // }
//             }
//         }
//         int[] result = new int[totalElement];
//         int index = 0;
//         for (int key : diagonalMap.keySet()) {
//         List<Integer> diagonalElements = diagonalMap.get(key);
//              for (int i = diagonalElements.size() - 1; i >= 0; i--) {
//                 result[index++] = diagonalElements.get(i);
//             }
//         }
//         return result;
//     }
// }
