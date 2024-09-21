// class Solution {
//     public List<Integer> lexicalOrder(int n) {
//         List<Integer> list = new ArrayList<>();
//         int curr = 1;
//         for (int i = 1; i <= n; i++) {
//             list.add(curr);
//             if (curr * 10 <= n) {
//                 curr = curr * 10;
//             } else {
//                 if (curr >= n) {
//                     curr = curr / 10;
//                 }
//                 curr++;
//                 while (curr % 10 == 0)
//                     curr /= 10;
//             }
//         }
//         return list;

//     }
// }


class Solution {
    public List<Integer> lexicalOrder(int n) {
    List<Integer> result = new ArrayList<>();
       for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }
        return result;
    }
     private void dfs(int curr, int n, List<Integer> result) {
        if (curr > n) return;  
        result.add(curr); 
        for (int i = 0; i <= 9; i++) {
            int next = curr * 10 + i;
            if (next > n) break;  
            dfs(next, n, result); 
        }
    }
}