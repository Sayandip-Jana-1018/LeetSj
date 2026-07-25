class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base Case 1: Both nodes are null. They perfectly match the "void".
        if (p == null && q == null) return true;
        
        // Base Case 2: One is null, but the other isn't. Structural mismatch!
        if (p == null || q == null) return false;
        
        // Base Case 3: The structures match, but the values inside don't.
        if (p.val != q.val) return false;
        
        // If we survived the checks, the current nodes are identical twins.
        // Now, ask the left branches if THEY are twins, AND ask the right branches.
        boolean leftIsSame = isSameTree(p.left, q.left);
        boolean rightIsSame = isSameTree(p.right, q.right);
        
        return leftIsSame && rightIsSame;
    }
}