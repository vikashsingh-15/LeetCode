class Solution {
    int post_index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post_index = postorder.length - 1;
        if (postorder.length == 0) return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursion(inorder, postorder, 0, postorder.length - 1, map);
    }

    public TreeNode recursion(int[] inorder, int[] postorder, int left, int right, HashMap<Integer, Integer> map) {
      if(left>right){
          return null;
      }
        TreeNode root = new TreeNode(postorder[post_index]);
        post_index--;
        int pos=map.get(root.val);
         root.right = recursion(inorder, postorder, pos + 1, right, map);
        root.left = recursion(inorder, postorder, left, pos - 1, map);
        return root;

    }
}
