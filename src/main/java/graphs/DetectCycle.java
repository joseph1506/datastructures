package graphs;

import java.util.LinkedList;

public class DetectCycle {
    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(0, 1);
        g.addEdge(4, 0);
        g.addEdge(4, 2);
        g.addEdge(2, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 4);

        if(isCyclePresent(g)){
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle");
        }

    }

    private static boolean isCyclePresent(Graph g) {
        boolean[] visited= new boolean[g.vertices];
        for(int i=0;i<g.vertices;i++){
            boolean cyclePresent= traverse(i,g,visited);
            if(cyclePresent) return true;
        }
        return false;
    }

    private static boolean traverse(int vertex, Graph g, boolean[] visited) {
        visited[vertex]=true;
        LinkedList<Integer> children= g.adj[vertex];
        for(Integer child:children){
            if(!visited[child]){
                boolean cyclePresent= traverse(child,g,visited);
                if(cyclePresent) return true;
            } else{
                return true;
            }
        }
        visited[vertex]=false;
        return false;
    }
}
