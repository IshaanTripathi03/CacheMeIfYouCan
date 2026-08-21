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
    private int length(ListNode head){
        int count=0;
        ListNode temp=head;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public ListNode rotateRight(ListNode head, int k) {
        int n=length(head);
        if(k==0 || head==null){
            return head;
        }
        k=k%n;
        if(k==0){
            return head;
        }
        ListNode fast=head;
        for(int i=0;i<k;i++){
            fast=fast.next;
        }
        ListNode slow=head;
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        ListNode newHead=slow.next;
        slow.next=null;
        fast.next=head;
        return newHead;
    }
}