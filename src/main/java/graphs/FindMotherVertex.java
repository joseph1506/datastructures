package graphs;

public class FindMotherVertex {

    public static void findMother(Graph graph){
        boolean[] visited = new boolean[graph.vertices];
        int lastFinished = 0;

        for(int i= 0;i<graph.vertices;i++){
            if(!visited[i]){
               graph.DFSRecUtil(i, visited);
               lastFinished = i;
            }
        }

        visited = new boolean[graph.vertices];
        graph.DFSRecUtil(lastFinished,visited);
        boolean isMother = true;

        for(boolean visit: visited){
            if(!visit){
                isMother= false;
                break;
            }
        }
        System.out.println(isMother?""+lastFinished:"");
    }

    public static void main(String[] args) {
            Graph g = new Graph(5);



    }
}
