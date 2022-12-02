package java;

/* Tree, depth first search
 * Given an integer array nums where the elements are sorted in ascending order, 
 * convert it to a height-balanced binary search tree.
 * A height-balanced binary tree is a binary tree in which the depth of the two 
 * subtrees of every node never differs by more than one.
 */

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


 /* 
  * Time complexity: O(n)
  * Space complexity: O(n)
  *
  * Test:
  * 1. Normal cases
  * 2. null array
  * 3. length 1 array
  * 4. long array
  */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return insert(nums, 0, nums.length - 1);
    }

    public TreeNode insert(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = insert(nums, left, middle - 1);
        root.right = insert(nums, middle + 1, right);
        return root;

    }
}
