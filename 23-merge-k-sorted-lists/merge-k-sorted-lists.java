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
    public ListNode mergeKLists(ListNode[] lists) {
         ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b) -> a.val-b.val);
        for(ListNode node:lists){
            if(node != null)
                pq.offer(node);
        }
        while(!pq.isEmpty()){
            ListNode top=pq.poll();
            curr.next=top;
            curr=curr.next;
            if(top.next != null){
                pq.offer(top.next);
            }
        }
        return dummy.next;
    }
}