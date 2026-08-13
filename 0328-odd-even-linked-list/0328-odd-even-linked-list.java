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
    public ListNode oddEvenList(ListNode head) {
        List<Integer> odd=new ArrayList<>();
        List<Integer> even=new ArrayList<>();
        ListNode temp=head;
        int c=1;
        while(temp!=null){
            if(c%2==1){
                odd.add(temp.val);
            }
            else{
                even.add(temp.val);
            }
            c++;
            temp=temp.next;
        }
        temp=head;
        int i=0;
        while(temp!=null && i<odd.size()){
            temp.val=odd.get(i++);
            temp=temp.next;
        }
        i=0;
        while(temp!=null && i<even.size()){
            temp.val=even.get(i++);
            temp=temp.next;
        }
        return head;
    }
}