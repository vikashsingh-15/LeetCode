class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();

        if (rowIndex < 0) {
            return new ArrayList<>();
        }

        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        result.add(firstRow);

        if (rowIndex == 0) {
            return firstRow;
        }

        for (int i = 1; i <= rowIndex; i++) {
            List<Integer> prev = result.get(i - 1);
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 1; j < i; j++) {
                temp.add(prev.get(j - 1) + prev.get(j));
            }
            temp.add(1);
            result.add(temp);
        }

        return result.get(rowIndex);
    }
}
