package java;

/* Hash table, stack, tree
 * Given the root of a binary tree, return the inorder traversal of 
 * its nodes' values.
 * 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * 
 * Test:
 * 1. root is null
 * 2. normal case
 * 3. inbalance tree
 * 4. large tree
 * 5. tree with only root node
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                stack.push(cur);
                // keep moving left.
                cur = cur.left;
            }
            // when cur is null, we reach the left leave.
            cur = stack.pop();
            list.add(cur.val);
            // new cur will become null if cur is a leave.
            // we will continue to next iteration to pop the parent node.
            cur = cur.right;
         }

        return list;
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