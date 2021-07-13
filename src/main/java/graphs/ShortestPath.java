package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Vector;

public class ShortestPath extends Exception {
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);

        System.out.println("Following is the Depth First Traversal");
        g.dfsTrav(0);
        g.dfsTravRecursion();
        Vector vector= new Vector();
    }


}
