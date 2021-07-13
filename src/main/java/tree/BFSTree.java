package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BFSTree {

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
        //bfsTraversal(a);
        System.out.println(bfsSearch(a,"p"));
    }

    private static void bfsTraversal(Node<String> root) {
        if(root==null) return;
        Queue<Node> queue= new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node<String> node= queue.poll();
            System.out.println(node.data);
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
    }

    private static boolean bfsSearch(Node<String> root,String target) {
        if(root==null) return false;
        Queue<Node> queue= new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            Node<String> node= queue.poll();
            if(target.equals(node.data)){
                return true;
            }
            //System.out.println(node.data);
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        return false;
    }


}
