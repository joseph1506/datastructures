package graphs;

import java.util.*;

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

    public void addEdgeBoth(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
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

    public void DFSRecUtil(int vertex, boolean[] visited) {
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
        Graph g = new Graph(8);
        g.addEdge(0, 1);
        g.addEdge(0, 3);
        g.addEdge(0, 5);

        g.addEdge(1, 0);
        g.addEdge(1, 6);
        g.addEdge(1, 2);
        g.addEdge(1, 5);

        g.addEdge(2, 1);
        g.addEdge(2, 7);

        g.addEdge(3, 0);
        g.addEdge(3, 4);

        g.addEdge(4, 3);
        g.addEdge(4, 5);

        g.addEdge(5, 4);
        g.addEdge(5, 0);
        g.addEdge(5, 6);
        g.addEdge(5, 1);

        g.addEdge(6, 1);
        g.addEdge(6, 5);
        g.addEdge(6, 7);

        g.addEdge(7, 6);
        g.addEdge(7, 2);

        /*System.out.println("Following is the Depth First Traversal");
        g.dfsTrav(0);
        g.dfsTravRecursion();*/

        /*System.out.println(g);
        int[] path= g.shortestPath(5);
        int parent=5;
        while(parent!=-1){
            System.out.print(parent);
            parent=path[parent];
        }*/

        g.gColorStart();

    }

    public int[] shortestPath(int endVertex){
        boolean[] visited=new boolean[this.vertices];
        int[] parents= new int[this.vertices];

        Queue<Integer> queue= new LinkedList<>();
        queue.add(0);
        visited[0]=true;
        parents[0]=-1;

        while(!queue.isEmpty()){
            int node= queue.poll();
            LinkedList<Integer> adjacency= this.adj[node];
            while(!adjacency.isEmpty()){
                int child= adjacency.poll();
                if(!visited[child]){
                    queue.offer(child);
                    parents[child]=node;
                    visited[child]=true;
                }
            }
            visited[node]=true;
        }
        return parents;
    }


    // bipartite checking for graph
    public void gColorStart(){
        boolean[] visited= new boolean[this.vertices];
        char[] colors= new char[this.vertices];
        Arrays.fill(colors,'N');

        for(int i=0;i<this.vertices;i++){
            if(!visited[i]){
                boolean flag= gColoring(i,visited,colors);
                if(!flag){
                    System.out.println("Failed");
                }
            }
        }
        System.out.println("Partite");
        System.out.println(colors);
    }

    private boolean gColoring(int vertex, boolean[] visited, char[] colors) {
        colors[vertex]='W';
        Stack<Integer> stack= new Stack<>();
        stack.push(vertex);

        while(!stack.isEmpty()){
            int node= stack.pop();

            if(!visited[node]){
                visited[node]=true;
                System.out.println(node);
            }


            Iterator<Integer> adjacents= this.adj[node].iterator();
            while(adjacents.hasNext()){
                int adjacent= adjacents.next();
                if(colors[adjacent]=='N'){
                    colors[adjacent]=colors[node]=='W'?'B':'W';
                } else{
                    if(colors[node]==colors[adjacent]){
                        return false;
                    }
                }
                if(!visited[adjacent]){
                    stack.add(adjacent);
                }
            }
        }
        return true;
    }


}
