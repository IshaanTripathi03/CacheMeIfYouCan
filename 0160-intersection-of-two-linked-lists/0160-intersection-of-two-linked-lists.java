/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int c1=0,c2=0;
        ListNode L1=headA,L2=headB;
        while(L1!=null){
            c1++;
            L1=L1.next;
        }
        while(L2!=null){
            c2++;
            L2=L2.next;
        }
        if(c1>c2){
            return getIntersectionNode(headB,headA);
        }
        int diff=c2-c1;
        L2=headB;
        while(L2!=null && diff>0){
            diff--;
            L2=L2.next;
        }
        L1=headA;
        while(L1!=null){
            if(L1==L2){
                return L1;
            }
            L1=L1.next;
            L2=L2.next;
        }
        return null;
    }
}