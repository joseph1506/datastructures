package graphs;

public class PossiblePathSourceDest {
    public static void main(String[] args) {
        int graph[][] =new int[][] {
                {0, 1, 1, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 0}
        };
        int u = 0, v = 3, k = 2;
        int N = 4;
        System.out.println(countKPaths(graph,u,v,k,N));

    }

    private static int countKPaths(int[][] graph, int start, int dest, int k, int N) {
        if(k==0 && start==dest){
            return 1;
        }
        if(k==1 && graph[start][dest]==1){
            return 1;
        }
        if(k<0){
            return 0;
        }

        int count = 0;

        for(int i =0;i<N;i++){
            if(graph[start][i]==1 && start!=i){
                count = count + countKPaths(graph,i,dest,k-1,N);
            }
        }

        return count;
    }
}
