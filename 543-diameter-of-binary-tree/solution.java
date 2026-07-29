/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxDiameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getDepth(root);
        return maxDiameter;
    }
    public int getDepth(TreeNode root) {
        if(root == null) return 0;
        int leftHeight = getDepth(root.left);
        int rightHeight = getDepth(root.right);
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}