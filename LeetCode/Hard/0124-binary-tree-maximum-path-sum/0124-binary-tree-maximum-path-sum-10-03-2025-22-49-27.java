class Solution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftsum = Math.max(0, dfs(root.left));
        int rightsum = Math.max(0, dfs(root.right));
        max = Math.max(max, leftsum + rightsum + root.val);

        return root.val + Math.max(leftsum, rightsum);
    }
}