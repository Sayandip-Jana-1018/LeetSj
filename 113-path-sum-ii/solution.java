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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPath(root, targetSum, currentPath, allPaths);
        return allPaths;
    }

    private void findPath(TreeNode root, int targetSum, List<Integer> currentPath, List<List<Integer>> allPaths) {
        if(root == null) return;

        currentPath.add(root.val);
        if(root.left == null && root.right == null && root.val == targetSum) allPaths.add(new ArrayList<>(currentPath));
        else {
            findPath(root.left, targetSum - root.val, currentPath, allPaths);
            findPath(root.right, targetSum - root.val, currentPath, allPaths);
        }
        currentPath.remove(currentPath.size() - 1);
    }
}