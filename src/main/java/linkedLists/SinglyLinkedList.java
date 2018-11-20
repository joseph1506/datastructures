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
        if(this.length==0){
            this.head = node;
            this.head.next = null;
        } else{
            Node curr = this.head;
            int counter=1;
            while(curr.next!=null && counter<pos-1){
                curr = curr.next;
                counter++;
            }
            Node<K> temp = curr.next;
            curr.next= node;
            node.next = temp;
        }
        length++;
    }

    public void addFirst(Node<K> node){
        node.next = this.head;
        this.head = node;
        length++;
    }

    public boolean delete(K value){
        Node curr= this.head;
        Node prev= this.head;
        Node next = this.head;
        if(this.length==0){
            return false;
        }

        if(curr.value!=null && curr.value.equals(value)){
            next = curr.next;
            this.head = next;
            length = length-1;
        } else {
            while(curr.next!=null){
                if(curr.value.equals(value)){
                       next = curr.next;
                       prev.next = next;
                       return true;
                }else {
                    prev= curr;
                    curr= curr.next;
                }
            }
        }
        return false;
    }
}
