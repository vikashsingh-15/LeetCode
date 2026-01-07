class Solution {
    private static final int MOD = 1_000_000_007;
    long total;
    long maxProduct = 0;

    public int maxProduct(TreeNode root) {
        total = getSum(root);     
        getSubtreeSum(root);      
        return (int)(maxProduct % MOD);
    }

   
    private long getSum(TreeNode root){
        if(root == null) return 0;
        return root.val + getSum(root.left) + getSum(root.right);
    }

    private long getSubtreeSum(TreeNode root){
        if(root == null) return 0;

        long left = getSubtreeSum(root.left);
        long right = getSubtreeSum(root.right);

        long subTreeSum = root.val + left + right;

        long product = subTreeSum * (total - subTreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subTreeSum;
    }
}
