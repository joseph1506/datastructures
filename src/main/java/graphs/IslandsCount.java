package graphs;

public class IslandsCount {

    public static void main(String[] args) {
        int M[][]=  new int[][] {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        /*int ROWS= 5;
        int COLUMNS = 5;*/

        System.out.println(countIslands(M));
    }

    private static int countIslands(int[][] matrix) {
        int islandCount= 0;
        int vertices= matrix.length;
        int edges=matrix[0].length;
        boolean[][] visited = new boolean[vertices][edges];
        for(int i=0;i<vertices;i++){
            for(int j=0;j<edges;j++){
                if(matrix[i][j]==1 && !visited[i][j]){
                    markTheIsland(i,j,matrix,visited,vertices,edges);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    private static void markTheIsland(int row, int col,int[][] matrix, boolean[][] visited, int vertices, int edges) {
        if(row<0||row>=vertices||col<0||col>=edges||visited[row][col]||matrix[row][col]!=1) return;
        visited[row][col]=true;

        markTheIsland(row,col-1,matrix,visited,vertices,edges);
        markTheIsland(row-1,col,matrix,visited,vertices,edges);
        markTheIsland(row,col+1,matrix,visited,vertices,edges);
        markTheIsland(row+1,col,matrix,visited,vertices,edges);
    }


}
