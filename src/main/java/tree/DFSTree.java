package tree;

import java.util.LinkedList;
import java.util.Stack;

public class DFSTree {
    public static void main(String[] args) {
        Node<String> a= new Node<>("a");
        Node<String> b= new Node<>("b");
        Node<String> c= new Node<>("c");
        Node<String> d= new Node<>("d");
        Node<String> e= new Node<>("e");
        Node<String> f= new Node<>("f");
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        c.right=f;
        //preOrder(a);
        //preOrderRecursion(a);
        inOrderRecursion(a);
    }

    private static void preOrder(Node<String> root) {
        if(root==null) return ;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node= stack.pop();
            System.out.println(node.data);
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
        }
    }

    private static void preOrderRecursion(Node<String> node) {
        if(node==null) return ;
        System.out.println(node.data);
        preOrderRecursion(node.left);
        preOrderRecursion(node.right);
    }

    private static void postOrder(Node<String> root) {
        if(root==null) return ;
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()){
            Node node= stack.peek();
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
            System.out.println(node.data);
            stack.pop();
        }
    }

    private static void postOrderRecursion(Node<String> node) {
        if(node==null) return ;

        postOrderRecursion(node.left);
        postOrderRecursion(node.right);
        System.out.println(node.data);
    }

    private static void inOrderRecursion(Node<String> node) {
        if(node==null) return ;

        inOrderRecursion(node.left);
        System.out.println(node.data);
        inOrderRecursion(node.right);
    }
}
