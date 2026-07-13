class Solution {
    public List<Integer> sequentialDigits(int low, int high) {

        List<Integer> ans = new ArrayList<>();
        String digits = "123456789";

        int lenLow = String.valueOf(low).length();
        int lenHigh = String.valueOf(high).length();

        for (int i = lenLow; i <= lenHigh; i++) {
            for (int start = 0; start + i <= 9; start++) {
                String x = digits.substring(start, start + i);
                int num = Integer.parseInt(x);

                if (num >= low && num <= high) {
                    ans.add(num);
                }
            }

        }
        return ans;
    }
}