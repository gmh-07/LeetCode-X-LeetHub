class Solution {
    private TreeNode helper(int low,int high,List<Integer> nums){
        if(low>high) return null;
        int mid = (high-low)/2+low;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = helper(low,mid-1,nums);
        root.right = helper(mid+1,high,nums);
        return root;
    }
    private void inorder(TreeNode root,List<Integer> list){
        if(root==null) return;
        inorder(root.left,list);
        list.add(root.val);
        inorder(root.right,list);
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        int n = list.size();
        int low = 0;
        int high = n-1;
        return helper(low,high,list);
    }
}