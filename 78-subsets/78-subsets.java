class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        // List<List<Integer>> ans = new ArrayList<>();
        // findsubsets(0, nums, new ArrayList<>(), ans);
        // return ans;
        
        //way 2
        List<List<Integer>> ans = new ArrayList<>();
        int limit=(int) Math.pow(2,nums.length);
        for(int i=0;i<limit;i++){
            int pos=i;
             List<Integer> temp=new ArrayList();
            for(int j=0;j<nums.length;j++){
                int rem=pos%2;
                pos=pos/2;
                if(rem!=0){
                    temp.add(nums[j]);
                }
            }
            ans.add(temp);
        }
        return ans;
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
