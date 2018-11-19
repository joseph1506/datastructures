package linkedLists;

public class SinglyLinkedList<K> {
    int length=0;
    Node<K> head;

    public SinglyLinkedList() {
        this.length = 0;
    }

    public SinglyLinkedList(Node<K> head) {
        this.appendNode(head);
    }

    public void appendNode(Node<K> node){
        if(this.length==0){
            this.head = node;
            this.head.next = null;
        } else{
            Node curr = this.head;
            while(curr.next!=null){
                curr = curr.next;
            }
            curr.next = node;
        }
        length++;
    }

    public void addAtPos(Node<K> node, int pos){

    }

    public void addFirst(Node<K> node){
        node.next = this.head;
        this.head = node;
        length++;
    }
}
