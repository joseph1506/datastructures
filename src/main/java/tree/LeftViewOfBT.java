package tree;

import static tree.BinaryTreeSize.sizeOfNode;

public class LeftViewOfBT {

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
        int sizeT= sizeOfNode(a);
        printLeftView(a,sizeT);


    }

    private static void printLeftView(Node<String> start, int height) {
        boolean[] levels= new boolean[height];

        int level=0;
        traverse(start,level,levels);
    }

    private static void traverse(Node<String> node, int level, boolean[] levels) {
        if(node==null) return;

        if(!levels[level]) {
            System.out.println(node.data);
            levels[level]=true;
        }
        traverse(node.left,level+1,levels);
        traverse(node.right,level+1,levels);
    }

}
