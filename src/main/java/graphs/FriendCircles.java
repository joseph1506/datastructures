package graphs;

public class FriendCircles {

    public static void main(String[] args) {
        int[][] persons = {
                {1,1,0,0},
                {1,1,1,0},
                {0,1,1,0},
                {0,0,0,1}
        };
        int N = 4;
        System.out.println(countFriendCircles(persons,N));
    }

    private static int countFriendCircles(int[][] persons, int N) {
        boolean[] visited = new boolean[N];
        int noOfCircles=0;
        for(int i=0;i<N;i++){
            if(!visited[i]){
                noOfCircles= noOfCircles+1;
                visited[i]= true;
                findFriendCircles(persons,i,visited,N);
            }
        }
        return noOfCircles;
    }

    private static void findFriendCircles(int[][] persons, int parent,
                                          boolean[] visited, int N) {

        for(int i=0;i<N;i++){
            if(i!=parent){
                if(!visited[i] && persons[parent][i]==1){
                    visited[i]= true;
                    findFriendCircles(persons,i,visited,N);
                }
            }
        }
    }
}

