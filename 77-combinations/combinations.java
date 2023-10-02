// class Solution {
//     public List<List<Integer>> combine(int n, int k) {
//         List<List<Integer>> ans = new ArrayList<>();
//         List<List<Integer>> outer = new ArrayList<>();
//         outer.add(new ArrayList<>());

//         for (int i = 1; i <= n; i++) {
//             int size = outer.size();
//             for (int j = 0; j < size; j++) {
//                 List<Integer> inner = new ArrayList<>(outer.get(j));
//                 inner.add(i);
//                 outer.add(inner);

//                 if (inner.size() == k) {
//                     ans.add(inner);
//                 }
//             }
//         }
//         return ans;
//     }
// }

//way 2

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combinations = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), combinations);
        return combinations;
    }

    private void backtrack(int start, int n, int k, List<Integer> currentCombination, List<List<Integer>> combinations) {
        if (currentCombination.size() == k) {
            combinations.add(new ArrayList<>(currentCombination));
            return;
        }
        for (int i = start; i <= n; i++) {
            currentCombination.add(i);
            backtrack(i + 1, n, k, currentCombination, combinations);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }
}