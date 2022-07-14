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
        if (left > right) {
            return null;
        }
        int temp = post_index;
        int curr_val = postorder[post_index];
        TreeNode root = new TreeNode(curr_val);
        post_index--;
        int pos = map.get(curr_val);
        root.right = recursion(inorder, postorder, pos + 1, right, map);
        root.left = recursion(inorder, postorder, left, pos - 1, map);

        // for(int i=left;i<=right;i++){
        //     if(inorder[i]==postorder[right]){
        //         root.left=recursion( inorder,postorder,left,i-1);
        //         root.right=recursion( inorder,postorder,i+1,right-1);
        //     }
        // }

        return root;
        //abbott
        //
    }
}
