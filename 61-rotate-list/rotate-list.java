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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
     ListNode curr=head;
        int length=1;
        while(curr.next!=null)
        {
            curr=curr.next;
            length++;
        }
        curr.next=head;
        k=k%length;
        int newf=length-k;
        ListNode newtail=head;
        for (int i = 1; i < newf; i++) {
            newtail = newtail.next;
        }
        ListNode newHead = newtail.next;
        newtail.next = null;

        return newHead;
    }
}