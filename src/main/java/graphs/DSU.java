package graphs;

import java.util.Arrays;
import java.util.stream.IntStream;

public class DSU {
    int vertices;
    int[] components;

    public DSU(int vertices) {
        this.vertices=vertices;
        this.components= new int[vertices];
        Arrays.fill(this.components,-1);
    }

    public DSU(int vertices,int[] components) {
        this.vertices=vertices;
        this.components= components;
    }

    public int findParent(int vertex){
        if(this.components[vertex]<0) return vertex;

        return findParent(this.components[vertex]);
    }

    public void union(int node1,int node2){
        int parentNode1= this.findParent(node1);
        int parentNode2= this.findParent(node2);
        if(parentNode1!=parentNode2){
            int sizeOfNode2Component= this.components[parentNode2];
            this.components[parentNode1]+= sizeOfNode2Component;
            this.components[parentNode2]=parentNode1;
        }
    }

    public static void minimizeMalwareSpread(int[][] network,int[] infectedNodes){
        int networkSize= network.length;
        DSU dsu= new DSU(networkSize);

        for(int i=0;i<networkSize;i++){
            // check if node is not an infected edge
            boolean isInfectedNode= checkIfInfected(infectedNodes,i);
            if(!isInfectedNode){
                int[] connections= network[i];
                for(int j=0;j<connections.length;j++){
                    // check if edge is 1 and not an infected edge
                    boolean isInfected= checkIfInfected(infectedNodes,j);
                    if(!isInfected && connections[j]!=0){
                        dsu.union(i,j);
                    }
                }
            }
        }
        print(dsu);
        //int[] components = clone(dsu.components);
        int maxConnections=0;
        int bestNode=0;
        for(int i=0;i<infectedNodes.length;i++){
            DSU inDSU= new DSU(networkSize,clone(dsu.components));
            int infectedNode= infectedNodes[i];
            int[] connections= network[infectedNode];

            for(int j=0;j<connections.length;j++){
                boolean isInfectedNode= checkIfInfected(infectedNodes,j);
                if(!isInfectedNode && connections[j]!=0){
                    inDSU.union(infectedNode,j);
                }
            }
            System.out.println("after infecting network with --->"+infectedNode);
            print(inDSU);
            // since the connections are in negative
            if(inDSU.components[infectedNode]<maxConnections){
                maxConnections=inDSU.components[infectedNode];
                bestNode=infectedNode;
            }
        }
        System.out.println("Maxx connection-->"+maxConnections);
        System.out.println("Best Node-->"+bestNode);
    }

    private static int[] clone(int[] components) {
        int[] clone= new int[components.length];
        for(int i=0;i<components.length;i++){
            clone[i]=components[i];
        }
        return clone;
    }

    private static boolean checkIfInfected(int[] infectedNodes, final int node) {
        return IntStream.of(infectedNodes)
                .anyMatch(rec->rec== node);
    }

    public static void main(String[] args) {
        /*DSU dsu= new DSU(10);
        System.out.println(dsu.findParent(5));
        dsu.union(2,3);
        print(dsu);
        printParent(dsu,3);
        dsu.union(8,3);
        print(dsu);
        printParent(dsu,3);*/
        testMinimizeMalwareSpread();
    }

    private static void testMinimizeMalwareSpread() {
        /*int[][] network= new int[3][3];
        fillArray(network,0);
        network[0][1]=1;
        network[1][0]=1;
        network[1][2]=1;
        network[2][1]=1;*/

        int[][] network= new int[4][4];
        fillArray(network,0);
        network[0][1]=1;
        network[1][0]=1;
        network[1][2]=1;
        network[2][1]=1;
        network[2][3]=1;
        network[3][2]=1;

        int[] infectedNodes= new int[]{0,1};
        minimizeMalwareSpread(network,infectedNodes);
        // [[0,1,0],[1,0,1],[0,1,0]] and [0,1]
    }

    private static void fillArray(int[][] network, int filler) {
        for(int i=0;i<network.length;i++){
            Arrays.fill(network[i],filler);
        }
    }

    public static void print(DSU dsu){
        for(int comp:dsu.components){
            System.out.print(comp+" ");
        }
        System.out.println("");
    }

    public static void printParent(DSU dsu,int node){
        System.out.println(dsu.findParent(node));
    }

}
