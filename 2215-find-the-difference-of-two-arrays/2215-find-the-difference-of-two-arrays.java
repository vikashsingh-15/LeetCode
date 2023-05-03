class Solution {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int num1 : nums1) {
            set1.add(num1);
        }
        for (int num2 : nums2) {
            set2.add(num2);
        }

        // if not present lets add to our list
        List<List<Integer>> ls = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int num1 : nums1) {
            if (!set2.contains(num1) && !a.contains(num1)) {
                a.add(num1);
            }
        }

        for (int num2 : nums2) {
            if (!set1.contains(num2) && !b.contains(num2)) {
                b.add(num2);
            }
        }
        ls.add(a);
        ls.add(b);
        return ls;
    }
}
