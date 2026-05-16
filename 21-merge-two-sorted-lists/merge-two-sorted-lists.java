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
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to easily handle the head of the new list
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        // Traverse both lists while neither is empty
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            // Move the current pointer forward
            current = current.next;
        }
        
        // If one of the lists is not empty, attach the remainder of it
        // Since both lists are already sorted, we can just link the rest
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        
        // The merged list starts right after the dummy node
        return dummy.next;
    }
}