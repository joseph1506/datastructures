package graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    int vertices;
    LinkedList<Integer> adj[];

    public Graph(int vertices){
        this.vertices = vertices;
        adj = new LinkedList[this.vertices];
        for(int i =0;i<this.vertices;i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int v, int w){
        adj[v].add(w);
    }

    public void bfsTrav(int startVertex){
        boolean[] visited = new boolean[this.vertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        visited[startVertex]= true;
        queue.add(startVertex);

        while(queue.size()!=0){
            int curr = queue.poll();
            System.out.print(curr+"");

            Iterator<Integer> adjacents= adj[curr].listIterator();
            while(adjacents.hasNext()){
                int n = adjacents.next();
                if(!visited[n]){
                    queue.add(n);
                    visited[n]= true;
                }
            }
        }

    }

    public void dfsTrav(int start){
        boolean[] visited = new boolean[this.vertices];
        Stack<Integer> nodeSt= new Stack<Integer>();
        nodeSt.push(start);

        while(nodeSt.size()!=0){
            int head = nodeSt.pop();

            if(!visited[head]){
                System.out.println(""+head);
                visited[head]=true;
            }

            Iterator<Integer> iter = adj[head].iterator();
            while(iter.hasNext()){
                int n = iter.next();
                if(!visited[n]){
                    nodeSt.push(n);
                }
            }

        }
    }

    public void dfsTravRecursion(){
        boolean[] visited = new boolean[this.vertices];

        for(int i =0;i<this.vertices;i++){
              if(!visited[i]){
                  DFSRecUtil(i, visited);
              }
        }
    }

    private void DFSRecUtil(int vertex, boolean[] visited) {
        System.out.println(""+vertex);
        visited[vertex]= true;


        Iterator<Integer> adjacents = adj[vertex].iterator();
        while(adjacents.hasNext()){
            int V = adjacents.next();
            if(!visited[V]){
                DFSRecUtil(V,visited);
            }
        }
    }

    public static void main(String[] args)
    {
        // Total 5 vertices in graph
        Graph g = new Graph(5);

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(1, 4);

        System.out.println("Following is the Depth First Traversal");
        g.dfsTrav(0);
        g.dfsTravRecursion();
    }
}
