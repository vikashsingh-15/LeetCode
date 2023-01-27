class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        helper(res, new ArrayList(), nums);
        return res;
    }
     public void helper(List<List<Integer>> res, List<Integer> row, int[] nums) {
        if (row.size() == nums.length) {
            res.add(new ArrayList(row));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (row.contains(nums[i])) {
                continue;
            }
            row.add(nums[i]);
            helper(res, row, nums);
            row.remove(row.size() - 1);
        }
    }
}