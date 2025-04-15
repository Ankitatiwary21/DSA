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
class Solution{
public boolean isPalindrome(ListNode head) {
    ListNode slow = head;
    ListNode fast = head;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }

    ListNode prev = null;
    ListNode current = slow;
    while (current != null) {
        ListNode temp = current.next;
        current.next = prev;
        prev = current;
        current = temp;
    }

    ListNode firstHalfIterator = head;
    ListNode secondHalfIterator = prev;
    while (secondHalfIterator != null) {
        if (secondHalfIterator.val != firstHalfIterator.val) {
            return false;
        }
        secondHalfIterator = secondHalfIterator.next;
        firstHalfIterator = firstHalfIterator.next;
    }

    return true;
}
}

