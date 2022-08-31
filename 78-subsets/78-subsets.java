class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        // List<List<Integer>> ans = new ArrayList<>();
        // findsubsets(0, nums, new ArrayList<>(), ans);
        // return ans;

        //         //way 2
        //         List<List<Integer>> ans = new ArrayList<>();
        //         int limit=(int) Math.pow(2,nums.length);
        //         for(int i=0;i<limit;i++){
        //             int pos=i;
        //              List<Integer> temp=new ArrayList();
        //             for(int j=0;j<nums.length;j++){

        //                 int rem=pos%2;
        //                 pos=pos/2;
        //                 if(rem!=0){
        //                     temp.add(nums[j]);
        //                 }

        //                 // // checks the setbit thsi can also be done
        //                 // if((num & (1<<j))!=0){
        //                 //     lst.add(nums[i]);
        //                 // }
        //             }
        //             ans.add(temp);
        //         }
        //         return ans;

        //way 3

        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for (int i = 0; i < nums.length; i++) {
            int n = outer.size();
            // System.out.println("Outer size "+ n);
            // System.out.println("Outer is "+ outer);
            for (int j = 0; j < n; j++) {
                ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                   // System.out.println("Inner is "+ inner);
                inner.add(nums[i]);
                  // System.out.println("Inner is after adding num[i] "+ inner);
                outer.add(inner);
                    // System.out.println("Outer is after adding inner "+ outer);
            }
        }
        return outer;
    }
    // public void findsubsets(int id, int[] nums, ArrayList<Integer> li, List<List<Integer>> ans) {
    //     ans.add(new ArrayList<>(li));
    //     // System.out.println("ans is "+ans);
    //     for (int i = id; i < nums.length; i++) {
    //         // System.out.println("id  is "+id);
    //         li.add(nums[i]);
    //         // System.out.println("Li is "+li);
    //         findsubsets(i + 1, nums, li, ans);
    //         li.remove(li.size() - 1);
    //     }
    // }
}
