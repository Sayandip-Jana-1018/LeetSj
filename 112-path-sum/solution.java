class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        
        if (root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        
        int remainingTarget = targetSum - root.val;
        
        boolean leftPath = hasPathSum(root.left, remainingTarget);
        boolean rightPath = hasPathSum(root.right, remainingTarget);
        
        return leftPath || rightPath;
    }
}