/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null) return null;
        if(root == p || root == q) return root;

        TreeNode leftFlare = lowestCommonAncestor(root.left, p, q);
        TreeNode rightFlare = lowestCommonAncestor(root.right, p, q);

        if(leftFlare != null && rightFlare != null) return root;

        return leftFlare != null ? leftFlare : rightFlare;
    }
}