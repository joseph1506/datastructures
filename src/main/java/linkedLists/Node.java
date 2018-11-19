package linkedLists;

public class Node<K> {
    K value;
    Node<K> next;

    public Node(K value, Node<K> next) {
        this.value = value;
        this.next = next;
    }

    public K getValue() {
        return value;
    }

    public void setValue(K value) {
        this.value = value;
    }

    public Node<K> getNext() {
        return next;
    }

    public void setNext(Node<K> next) {
        this.next = next;
    }
}
