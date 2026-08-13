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
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head,fast=head,L1=head;
        while(fast!=null && fast.next!=null){
            L1=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        L1.next=null;
        ListNode temp=slow, prev=null;
        while(temp!=null){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        while(head!=null){
            if(head.val!=prev.val){
                return false;
            }
            head=head.next;
            prev=prev.next;
        }
        return true;
    }
}