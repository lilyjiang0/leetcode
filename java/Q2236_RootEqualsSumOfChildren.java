package java;

/* Tree, Binary Tree
 * You are given the root of a binary tree that consists of exactly 3 nodes: 
 * the root, its left child, and its right child.
 * Return true if the value of the root is equal to the sum of the values of 
 * its two children, or false otherwise.
 * 
 * Constraints:
 *  The tree consists only of the root, its left child, and its right child.
 *  -100 <= Node.val <= 100
 * 
 * Test cases:
 * 1. normal cases: equal/not equal
 * 2. null input
 * 3. edge cases: Node.val = -100, Node.val = 100
 */

/* 
 * Time complexity: O(1)
 * Space complexity: O(1)
 */
class Solution {
    public boolean checkTree(TreeNode root) {
        return root.left.val + root.right.val == root.val;

    }
}

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
