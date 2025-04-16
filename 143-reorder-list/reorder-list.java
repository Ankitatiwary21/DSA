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
    public void reorderList(ListNode head) {
         if(head == null && head.next == null){
            return;
        }

        ListNode slow=head;
        ListNode fast = head;
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode right = slow.next;
        slow.next = null;
        right = sort(right);
        ListNode left = head;

        while(left != null && right != null){
            cur.next = left;
            cur = cur.next;
            left = left.next;
            cur.next = right;
            cur = cur.next;
            right = right.next;
        }
        if(left != null){
            cur.next = left;
        }
        if(right != null){
            cur.next = right;
        }
        
        head = dummy;
    }

    private static ListNode sort(ListNode right) {
          ListNode prev = null;
        ListNode nxt = right;

          while(right != null){
              nxt = right.next;
              right.next = prev;
              prev = right;
              right = nxt;
          }

          return prev;
        
    }
}