/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp=head;
        HashMap<Node ,Node> map=new HashMap<>();
        while(temp!=null){
            Node newNode=new Node(temp.val);
            map.put(temp,newNode);
            temp=temp.next;
        }
        temp=head;
        Node result=new Node(-1);
        Node resHead=result;
        while(temp!=null){
            result.next=map.get(temp);
            result=result.next;
            result.next=map.get(temp.next);
            result.random=map.get(temp.random);
            temp=temp.next;
        }
        return resHead.next;
    }
}