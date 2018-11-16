package graphs;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {

    public static void main(String[] args) {
        Graph g = new Graph(10);
        g.addEdge(0,1);
        g.addEdge(0,2);
        g.addEdge(3,0);
        g.addEdge(3,2);
        g.addEdge(3,4);
        g.addEdge(2,5);
        g.addEdge(6,4);
        g.addEdge(6,5);
        g.addEdge(6,7);
        g.addEdge(6,8);
        g.addEdge(7,4);
        g.addEdge(8,7);
        g.addEdge(9,8);
        topologicalSort(g);
    }

    private static void topologicalSort(Graph graph) {
        boolean[] visited = new boolean[graph.vertices];
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0;i<graph.vertices;i++){
            if(!visited[i]){
                sortUtil(i,graph,visited,stack);
            }
        }

        while(!stack.isEmpty()){
            System.out.print("-->"+stack.pop());
        }
    }

    private static void sortUtil(int vertex, Graph graph, boolean[] visited, Stack<Integer> stack) {
        visited[vertex] = true;
        Iterator<Integer> childNodes = graph.adj[vertex].iterator();

        while(childNodes.hasNext()){
            int V = childNodes.next();
            if(!visited[V]){
                sortUtil(V, graph, visited, stack);
            }
        }
        stack.push(vertex);
    }


}
