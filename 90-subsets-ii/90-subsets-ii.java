import java.util.*;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        findsubsets(0,nums,new ArrayList<>(),res);
        return res;
        
        
        
//         //way2
//         List<List<Integer>> ans = new ArrayList<>();
//         Set<List<Integer>> set = new HashSet<>();
//         int limit = (int) Math.pow(2, nums.length);
//         for (int i = 0; i < limit; i++) {
//             int pos = i;
//             List<Integer> temp = new ArrayList();
//             for (int j = 0; j < nums.length; j++) {
//                 int rem = pos % 2;
//                 pos = pos / 2;
//                 if (rem != 0) {
//                     temp.add(nums[j]);
//                 }
//                 // // checks the setbit thsi can also be done
//                 // if((num & (1<<j))!=0){
//                 //     lst.add(nums[i]);
//                 // }
//             }
//             Collections.sort(temp);
//             if (!set.contains(temp)) {
//                 Collections.sort(temp);
//                 set.add(temp);
//                 ans.add(temp);
//             }
//         }
//         return ans;
    }
    
    
    
    public void findsubsets(int id, int[] nums, ArrayList<Integer> li, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(li));
        for (int i = id; i < nums.length; i++) {
             if(id != i && nums[i]==nums[i-1]) continue;//this line removes duplicate
            li.add(nums[i]);
            findsubsets(i + 1, nums, li, ans);
            li.remove(li.size() - 1);
        }
    }
}
