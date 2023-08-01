class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        //way1
        List<List<Integer>> ans = new ArrayList<>();
        findsubsets(0, nums, new ArrayList<>(), ans);
        return ans;

        //         //way 2
        
        
        // List<List<Integer>> ans = new ArrayList<>();
        // int limit = (int) Math.pow(2, nums.length);
        // for (int i = 0; i < limit; i++) {
        //     // System.out.println("For i =" + i);
        //     int pos = i;
        //     List<Integer> temp = new ArrayList();
        //     for (int j = 0; j < nums.length; j++) {
        //         // System.out.println(" for j =" + j);
        //         int rem = pos % 2;
        //         pos = pos / 2;
        //         // System.out.print(" rem =" + rem);
        //         // System.out.print(" pos =" + pos);
        //         if (rem != 0) {
        //             // System.out.print(" added =" + nums[j]);
        //             temp.add(nums[j]);
        //         }
        //         // System.out.println();
        //     }
        //     // System.out.println(" temp = " +Arrays.toString(temp.toArray()));
        //     ans.add(temp);
        //     // System.out.println(" ans =  "+Arrays.toString(ans.toArray()));
        // }
        // return ans;
        
        
        //way 3

        //         List<List<Integer>> outer = new ArrayList<>();
        //         outer.add(new ArrayList<>());
        //         for (int i = 0; i < nums.length; i++) {
        //             int n = outer.size();
        //             for (int j = 0; j < n; j++) {
        //                 ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
        //                 inner.add(nums[i]);
        //                 outer.add(inner);
        //             }
        //         }
        //         return outer;
    }
    public void findsubsets(int id, int[] nums, ArrayList<Integer> li, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(li));
        // System.out.println("ans is "+ans);
        for (int i = id; i < nums.length; i++) {
            // System.out.println("id  is "+id);
            li.add(nums[i]);
            // System.out.println("Li is "+li);
            findsubsets(i + 1, nums, li, ans);
            li.remove(li.size() - 1);
        }
    }
}
