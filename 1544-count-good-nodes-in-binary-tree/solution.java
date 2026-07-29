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
    public int goodNodes(TreeNode root) {
        return countGoodNodes(root, root.val);
    }
    private int countGoodNodes(TreeNode root, int maxSoFar) {
        if(root == null) return 0;
        int count = 0;
        if(root.val >= maxSoFar) count = 1;

        int newMax = Math.max(root.val, maxSoFar);

        int leftTree = countGoodNodes(root.left, newMax);
        int rightTree = countGoodNodes(root.right, newMax);

        return count + leftTree + rightTree;
    }
}