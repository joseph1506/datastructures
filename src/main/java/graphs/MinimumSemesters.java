package graphs;

import java.util.*;

/*There are N courses, labelled from 1 to N.
        We are given relations[i] = [X, Y], representing a prerequisite relationship between course X and course Y: course X has to be studied before course Y.
        In one semester you can study any number of courses as long as you have studied all the prerequisites for the course you are studying.
        Return the minimum number of semesters needed to study all courses.  If there is no way to study all the courses, return -1.

        Example 1:
        Input: N = 3, relations = [[1,3],[2,3]]
        Output: 2
        Explanation:
        In the first semester, courses 1 and 2 are studied. In the second semester, course 3 is studied.

        Example 2:
        Input: N = 3, relations = [[1,2],[2,3],[3,1]]
        Output: -1
        Explanation:
        No course can be studied because they depend on each other.

        Note:
        1 <= N <= 5000
        1 <= relations.length <= 5000
        relations[i][0] != relations[i][1]
        There are no repeated relations in the input.*/
public class MinimumSemesters {

    public static void main(String[] args) {
        int N=4;
        int[][] relations= new int[N+1][N+1];
        for(int i=0;i<=N;i++){
            Arrays.fill(relations[i],0);
        }
        /*relations[1][3]=1;
        relations[2][3]=1;*/
        /*relations[1][2]=1;
        relations[2][3]=1;
        relations[3][1]=1;*/

        relations[1][2]=1;
        relations[2][3]=1;
        relations[4][3]=1;

        System.out.println(minimumSemesters(N,relations));


    }

    public static int minimumSemesters(int N, int[][] relations){
         Graph graph= new Graph(N);
         int[] inDegree= new int[N+1];
         for(int i=1;i<=N;i++){
             for(int j=1;j<=N;j++){
                 if(relations[i][j]==1) {
                     graph.addEgde(i,j);
                     inDegree[j]+=1;
                 }
             }
         }



        System.out.println(graph);

        Queue<Integer> sources= new LinkedList();

        for(int i=1;i<=N;i++){
            if(inDegree[i]==0){
                sources.offer(i);
            }
        }

        System.out.println(sources);
        boolean[] visited = new boolean[N+1];
        int semester=0;
        int nodesRemaining=N;
        while(!sources.isEmpty()){
            Queue<Integer> nextSemester= new LinkedList<>();
            for(Integer source:sources){
                if(!visited[source]){
                    nodesRemaining-=1;
                    LinkedList<Integer> neighbours= graph.adj[source];
                    for(Integer neighbour:neighbours){
                        inDegree[neighbour]-=1;
                        if(!visited[neighbour] && inDegree[neighbour]==0){
                            nextSemester.add(neighbour);
                        }
                    }
                }
                visited[source]=true;
            }
            sources=nextSemester;
            semester++;
        }
        return nodesRemaining==0?semester:-1;
    }

    public static class Graph{
        int vertices;
        LinkedList<Integer> adj[];

        public Graph(int vertices){
            this.vertices=vertices;
            this.adj= new LinkedList[vertices+1];

            for(int i=0;i<=vertices;i++){
                this.adj[i]= new LinkedList<>();
            }
        }

        public void addEgde(int v,int w){
            this.adj[v].add(w);
        }

    }






}
