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
    private ListNode tillKthNode(ListNode temp,int k){
        int counter=0;
        while(temp!=null){
            counter++;
            if(counter==k){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    private ListNode reverse(ListNode head){
        ListNode temp=head,prev=null;
        while(temp!=null){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head,prevGroupTail=null;
        while(temp!=null){
            ListNode revTail=tillKthNode(temp,k);
            if(revTail==null){
                break;
            }
            ListNode front=revTail.next;
            revTail.next=null;
            ListNode prevGroup=temp;
            ListNode revHead=reverse(temp);
            if(prevGroupTail==null){
                head=revHead;
            }
            else{
                prevGroupTail.next=revHead;
            }
            prevGroup.next=front;
            prevGroupTail=prevGroup;
            temp=front;
        }
        return head;
    }
}