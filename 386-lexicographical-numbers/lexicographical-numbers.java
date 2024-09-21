class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        int curr = 1;
        for (int i = 1; i <= n; i++) {
            list.add(curr);
            if (curr * 10 <= n) {
                curr = curr * 10;
            } else {
                if (curr >= n) {
                    curr = curr / 10;
                }
                curr++;
                while (curr % 10 == 0)
                    curr /= 10;
            }
        }
        return list;

    }
}