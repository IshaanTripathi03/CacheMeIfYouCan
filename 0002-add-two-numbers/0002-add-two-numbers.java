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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1=l1,temp2=l2;
        ListNode result=new ListNode(-1);
        ListNode head=result;
        int carry=0;
        while(temp1!=null && temp2!=null){
            int sum=temp1.val+temp2.val+carry;
            carry=sum>9?1:0;
            ListNode value=new ListNode(sum%10);
            result.next=value;
            result=value;
            temp1=temp1.next;
            temp2=temp2.next;
        }
        while(temp1!=null){
            int sum=temp1.val+carry;
            carry=sum>9?1:0;
            ListNode value=new ListNode(sum%10);
            result.next=value;
            result=value;
            temp1=temp1.next;
        }
        while(temp2!=null){
            int sum=temp2.val+carry;
            carry=sum>9?1:0;
            ListNode value=new ListNode(sum%10);
            result.next=value;
            result=value;
            temp2=temp2.next;
        }
        if(carry==1){
            ListNode value=new ListNode(carry);
            result.next=value;
        }
        return head.next;
    }
}