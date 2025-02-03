// /**
//  * Definition for a binary tree node.
//  * public class TreeNode {
//  *     int val;
//  *     TreeNode left;
//  *     TreeNode right;
//  *     TreeNode() {}
//  *     TreeNode(int val) { this.val = val; }
//  *     TreeNode(int val, TreeNode left, TreeNode right) {
//  *         this.val = val;
//  *         this.left = left;
//  *         this.right = right;
//  *     }
//  * }
//  */
class Solution {
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        inOrder(root,map);

        int maxFreq = 0;
        for (int count : map.values()) {
            maxFreq = Math.max(maxFreq, count);
        }

        int count=0;
        for(int key:map.keySet()){
            if(map.get(key)==maxFreq){
                count++;
            }
        }

        int ans[]=new int [count];
        int i=0;
        for(int key:map.keySet()){
            if(map.get(key)==maxFreq){
                ans[i++]=key;
            }
        }

        return ans;
    }

    public void inOrder(TreeNode root, Map<Integer, Integer> map ){
        if(root==null){
            return;
        }
        inOrder(root.left,map);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        inOrder(root.right,map);
    }
}


////way 2




// class Solution {
//     public int[] findMode(TreeNode root) {
//         List<Integer> list=new ArrayList<>();
//         inOrder(root,list);
//         Map<Integer, Integer> map = new HashMap<>();
//         int maxCount = 0;
//         for(int val:list){
//             map.put(val,map.getOrDefault(val,0)+1);
//             maxCount=Math.max(maxCount,map.get(val));
//         }
//         List<Integer> result = new ArrayList<>();
//         for(Integer keys:map.keySet()){
//             int value=map.get(keys);
//             if(value==maxCount){
//                 result.add(keys);
//             }
//         }
//          int[] resultArray = new int[result.size()];
//         for (int i = 0; i < result.size(); i++) {
//             resultArray[i] = result.get(i);
//         }
//         return resultArray;
        
//     }

//     public void inOrder(TreeNode root,List<Integer> list){
//         if(root==null){
//             return;
//         }
//         inOrder(root.left,list);
//         list.add(root.val);
//         inOrder(root.right,list);
//     }
// }


////way 3

// public class Solution {
//     private int currentVal;
//     private int currentCount;
//     private int maxCount;
//     private List<Integer> modes = new ArrayList<>();

//     public int[] findMode(TreeNode root) {
//         inOrderTraversal(root);
//         int[] result = new int[modes.size()];
//         for (int i = 0; i < modes.size(); i++) {
//             result[i] = modes.get(i);
//         }
//         return result;
//     }

//     private void inOrderTraversal(TreeNode node) {
//         if (node == null) {
//             return;
//         }

//         inOrderTraversal(node.left);

//         if (node.val == currentVal) {
//             currentCount++;
//         } else {
//             currentVal = node.val;
//             currentCount = 1;
//         }

//         if (currentCount == maxCount) {
//             modes.add(node.val);
//         } else if (currentCount > maxCount) {
//             modes.clear();
//             modes.add(node.val);
//             maxCount = currentCount;
//         }

//         inOrderTraversal(node.right);
//     }
// }