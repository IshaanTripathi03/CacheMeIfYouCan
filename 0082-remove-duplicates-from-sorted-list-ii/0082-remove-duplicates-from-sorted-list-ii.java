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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode list=new ListNode(0);
        list.next=head;
        ListNode current=head,prev=list;
        while(current!=null){
            if(current.next!=null && current.val==current.next.val){
                int data=current.val;
                while(current!=null && current.val==data){
                    current=current.next;
                }
                prev.next=current;
            }
            else{
                prev=current;
                current=current.next;
            }
        }
        return list.next;
    }
}