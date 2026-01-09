class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }
    private class Pair{
        TreeNode node;
        int depth;
        Pair(TreeNode node,int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    private Pair dfs(TreeNode root) {
        if (root == null) return new Pair(null, 0);

        Pair left = dfs(root.left);
        Pair right = dfs(root.right);

        // If both sides have same depth, this root is LCA of deepest nodes
        if (left.depth == right.depth) {
            return new Pair(root, left.depth + 1);
        } 
        // Otherwise go deeper on the deeper side
        else if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
        } else {
            return new Pair(right.node, right.depth + 1);
        }
    }
}