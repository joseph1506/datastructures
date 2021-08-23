package graphs;

import java.util.LinkedList;

public class DetectCycleUnDirectedGraph {

    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdgeBoth(0, 1);
        g.addEdgeBoth(0, 2);
        g.addEdgeBoth(0, 3);
        g.addEdgeBoth(1, 2);
        g.addEdgeBoth(3, 4);

        if(isCyclePresent(g)){
            System.out.println("Cycle Detected");
        } else {
            System.out.println("No Cycle");
        }

    }

    private static boolean isCyclePresent(Graph graph) {

        for(int i=0;i< graph.vertices;i++){
            boolean[] visited = new boolean[graph.vertices];
            boolean cycleDetected= traverse(i,-1,visited,graph);
            if(cycleDetected) return cycleDetected;
        }

        return false;
    }

    private static boolean traverse(int vertex, int parent, boolean[] visited, Graph graph) {
        visited[vertex]=true;

        LinkedList<Integer> adjacents= graph.adj[vertex];
        for(Integer child: adjacents){
            if(visited[child] && child!=parent) {
                return true;
            } else {
                if(child!=parent){
                    boolean isCyclePresent= traverse(child,vertex,visited,graph);
                    if(isCyclePresent) return true;
                }
            }
        }

        return false;
    }
}
