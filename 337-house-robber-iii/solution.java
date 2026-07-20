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
    public int rob(TreeNode root) {
        int[] result = robTree(root);
        return Math.max(result[0], result[1]);
    }
    private int[] robTree(TreeNode node) {
        if(node == null) return new int[]{0, 0};
        int[] leftChild = robTree(node.left);
        int[] rightChild = robTree(node.right);

        int skip = Math.max(leftChild[0], leftChild[1]) + Math.max(rightChild[0], rightChild[1]);

        int rob = node.val + leftChild[0] + rightChild[0];

        return new int[]{skip, rob};
    }
}