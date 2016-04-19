private int helper(TreeNode root, int sum) {
    if (root.left == null && root.right == null) 
        // x 
    if (root.left == null) 
        // y 
    if (root.right == null)
        // z
    return helper(root.right, sum * 10 + root.val) + helper(root.left, sum * 10 + root.val);
}