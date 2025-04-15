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
    ListNode rev(ListNode head)
    {
        ListNode cur=head;
        ListNode prev=null;
        while(cur!=null)
        {
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        return prev;
    }
public boolean isPalindrome(ListNode head) {
  ListNode fast=head;
  ListNode slow=head;
  while(fast.next!=null && fast.next.next!=null)
  {
    fast=fast.next.next;
    slow=slow.next;
  }
  ListNode secondhalf=slow.next;
  slow.next=null;
  secondhalf=rev(secondhalf);
  while(secondhalf!=null)
  {
   if(head.val!=secondhalf.val)
   {
    return false;

   }
   head=head.next;
   secondhalf=secondhalf.next;
  }
  return true;
}
}
