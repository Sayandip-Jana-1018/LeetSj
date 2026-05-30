class Solution {
    public boolean isBalanced(TreeNode root) {
        return checkHeight(root) != -1;
    }
    private int checkHeight(TreeNode root) {
        if(root == null) return 0;
        int leftNode = checkHeight(root.left);
        if(leftNode == -1) return -1;
        int rightNode = checkHeight(root.right);
        if(rightNode == -1) return -1;
        
        if(Math.abs(leftNode - rightNode) > 1) return -1;

        return Math.max(leftNode, rightNode) + 1;
    }
}