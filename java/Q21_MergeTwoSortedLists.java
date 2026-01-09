package java;

/* Linked list.
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Constraints:
- The number of nodes in both lists is in the range [0, 50].
- -100 <= Node.val <= 100
- Both list1 and list2 are sorted in non-decreasing order.

Time complexity: O(m+n) (m is length of list1 and n is length of list2)
Space complexity: O(1)

Test:
1. Normal cases.
2. Empty lists.
3. Number of nodes = 50.
4. List contains negative value like -100.
5. Node val = 100.
6. Every node in one list has greater value than the nodes in the other list.
7. All equal Node value.
8. Single-node lists.
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Track the head.
        ListNode dummy = new ListNode();
        // Track current node.
        ListNode cur = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
            
        }

        // If one list reaches the end, just take the rest of the other list.
        // Conditional expression: curr.next = (list1 != null) ? list1 : list2
        if (list1 == null) {
            cur.next = list2;
        } else {
            cur.next = list1;
        }

        return dummy.next;
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