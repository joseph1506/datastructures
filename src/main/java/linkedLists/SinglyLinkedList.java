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

    public Node deleteNew(K value){

        if(length==0) return head;
        if(head.value.equals(value)){
            head=head.next;
        } else {
            Node prev=null;
            Node curr=head;
            boolean deleted= delete(prev,curr,value);
        }
        return head;
    }

    private boolean delete(Node prev, Node curr, K value) {
        if(curr==null) return false;
        if(curr.value.equals(value)){
            prev.next=curr.next;
            return true;
        }else{
            return delete(curr,curr.next,value);
        }
    }

    public Node reverseList(){
        if(length==0 || length==1) return head;

        return reverse(head,null);
    }

    public Node reverse(Node current,Node prev){
        if(current==null) return prev;

        Node next= current.next;
        current.next=prev;
        return reverse(next,current);
    }
}
