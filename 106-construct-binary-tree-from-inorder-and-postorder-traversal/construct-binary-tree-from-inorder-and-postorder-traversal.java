// class Solution {
//     int post_index;

//     public TreeNode buildTree(int[] inorder, int[] postorder) {
//         post_index = postorder.length - 1;
//         if (postorder.length == 0) return null;
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for (int i = 0; i < inorder.length; i++) {
//             map.put(inorder[i], i);
//         }
//         return recursion(inorder, postorder, 0, post_index, map);
//     }

//     public TreeNode recursion(int[] inorder, int[] postorder, int left, int right, HashMap<Integer, Integer> map) {
//     if(left>right){
//         return null;
//     }
//         TreeNode root=new TreeNode();
//         root.val=postorder[post_index];
//         post_index--;
//         int inOrderPosition=map.get(root.val);
        
//         root.right=recursion(inorder,postorder,inOrderPosition+1,right,map);
//         root.left=recursion(inorder,postorder,left,inOrderPosition-1,map);
//         return root;
//     }
// }


class Solution {
    int post_index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post_index = postorder.length - 1;
        if (postorder.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, postorder, 0, post_index, map);
    }

    public TreeNode helper(int[] inorder, int[] postorder, int start, int end, HashMap<Integer, Integer> map) {
        if(start>end || post_index < 0 ){
            return null;
        }
        TreeNode root= new TreeNode(postorder[post_index]);
        int x=map.get(postorder[post_index]);
        post_index--;

        root.right=helper(inorder,postorder,x+1,end,map);
        root.left=helper(inorder,postorder,start,x-1,map);
        return root;


    }
}
