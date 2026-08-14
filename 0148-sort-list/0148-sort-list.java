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
    ListNode merge(ListNode leftHead,ListNode rightHead){
        ListNode list=new ListNode(-1);
        ListNode temp=list;
        while(leftHead!=null && rightHead!=null){
            if(leftHead.val<rightHead.val){
                temp.next=leftHead;
                temp=leftHead;
                leftHead=leftHead.next;
            }
            else{
                temp.next=rightHead;
                temp=rightHead;
                rightHead=rightHead.next;
            }
        }
        if(leftHead!=null){
            temp.next=leftHead;
        }
        else{
            temp.next=rightHead;
        }
        return list.next;
    }
    ListNode findMiddle(ListNode head){
        ListNode slow=head,fast=head.next;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode mid=findMiddle(head);
        ListNode leftHead=head,rightHead=mid.next;
        mid.next=null;
        leftHead=sortList(leftHead);
        rightHead=sortList(rightHead);
        return merge(leftHead,rightHead);
    }
}