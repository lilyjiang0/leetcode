package java;

/*
 * You are given the head of a linked list, which contains a series of integers separated by 0's. 
 * The beginning and end of the linked list will have Node.val == 0.
 * 
 * For every two consecutive 0's, merge all the nodes lying in between them into a single node 
 * whose value is the sum of all the merged nodes. The modified list should not contain any 0's.
 * 
 * Return the head of the modified linked list.
 * 
 * Constraints:
 *  The number of nodes in the list is in the range [3, 2 * 105].
 *  0 <= Node.val <= 1000
 *  There are no two consecutive nodes with Node.val == 0.
 *  The beginning and end of the linked list have Node.val == 0.
 * 
 * Test cases:
 * 1. normal cases
 * 2. null input
 * 3. edge cases: num of nodes = 3, num of nodes = 2 * 105
 * 4. edge cases: node.val = 0, node.val = 1000
 * 5. Large amount of integers between 0's, only 1 integers between 0's
 */

/* 
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode prev = new ListNode();
        ListNode dummy = new ListNode();
        prev = dummy; // Dummy head.
        while (head.next != null) { // Check if reach the end.
            prev.next = head;
            head = head.next;
            while (head.val != 0) { // Add all not 0 value.
                prev.next.val += head.val;
                head = head.next;
            }
            prev = prev.next;
        }
        prev.next = null; // Cut off the list.
        return dummy.next;
    }
}

/* Better memory usage.
 * Time complexity: O(n)
 * Space complexity: O(1)
 */
class Solution2 {
    public ListNode mergeNodes(ListNode head) {
        ListNode curr = new ListNode();
        ListNode root = new ListNode();
        curr = root; // Dummy head.
        int sum = 0;
        while (head != null) {
            if (head.val == 0 && sum != 0) {
                curr.next = new ListNode(sum);
                sum = 0;
                curr = curr.next;
            }
            sum += head.val;
            head = head.next;
        }
        return root.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
