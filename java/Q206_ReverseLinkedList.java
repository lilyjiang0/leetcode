package java;

/* Linked List
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

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


/* Iterative
  * Time complexity: O(n)
  * Space complexity: O(1)
  *
  * Test:
  * 1. Normal cases
  * 2. head is null
  * 3. length 1 linked list
  * 4. long list
  */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            
        }
        return prev;
    }
}


/* Recursive
  * Time complexity: O(n)
  * Space complexity: O(n)
  *
  * Test:
  * 1. Normal cases
  * 2. head is null
  * 3. length 1 linked list
  * 4. long list
  */
  class Solution2 {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }

    public ListNode reverse(ListNode head, ListNode newNext) {
        if (head == null) {
            return newNext;
        }
        ListNode next = head.next;
        head.next = newNext;
        return reverse(next, head);
    }

}