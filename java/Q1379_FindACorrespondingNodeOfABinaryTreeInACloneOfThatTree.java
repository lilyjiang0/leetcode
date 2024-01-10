package java;

/*
 * Given two binary trees original and cloned and given a reference to a node target in the 
 * original tree.
 * 
 * The cloned tree is a copy of the original tree.
 * Return a reference to the same node in the cloned tree.
 * Note that you are not allowed to change any of the two trees or the target node and the 
 * answer must be a reference to a node in the cloned tree.
 * 
 * Constraints:
 * The number of nodes in the tree is in the range [1, 104].
 * The values of the nodes of the tree are unique.
 * target node is a node from the original tree and is not null.
 * 
 * Test cases:
 * 1. normal cases
 * 2. original and cloned are null
 * 3. edge cases: number of node = 1, number of node = 104
 * 3. edge cases: target node is the deepest left/right node, target node is the root
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 */
class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target) {
            return cloned;
        }
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if (left != null) {
            return left;
        }
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        return right;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */