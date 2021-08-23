package tree;

import java.util.Queue;
import java.util.Stack;

public class BinaryTreeSize {
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
        c.left=f;
        System.out.println(sizeOfNodeIterative(a));
    }

    public static int sizeOfNode(Node node) {
        if(node==null) return 0;
        int rightSize= sizeOfNode(node.right);
        int leftSize= sizeOfNode(node.left);
        return rightSize+leftSize+1;
    }

    private static int sizeOfNodeIterative(Node node){
        int sizeOfTree=0;
        if(node==null) return sizeOfTree;

        Stack<Node> nodes= new Stack<>();
        nodes.push(node);

        while(!nodes.isEmpty()){
          Node nodeInStack= nodes.pop();
          sizeOfTree++;
          if(nodeInStack.left!=null) nodes.push(nodeInStack.left);

          if(nodeInStack.right!=null) nodes.push(nodeInStack.right);
        }
        return sizeOfTree;
    }
}
