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
        int ROWS= 5;
        int COLUMNS = 5;

        System.out.println(countIslands(M,ROWS,COLUMNS));
    }

    private static int countIslands(int[][] nodes,int ROWS, int COLUMNS) {
        int count= 0;
        boolean[][] visited = new boolean[ROWS][COLUMNS];
        for(int i=0;i<ROWS;i++){
            for(int j=0;j<COLUMNS;j++){
                dfs(nodes,visited,i,j,ROWS,COLUMNS);
                count++;
            }
        }


        return count;
    }

    private static void dfs(int[][] nodes, boolean[][] visited, int row, int column, int M, int N) {
        int[] rowN = {-1,-1,-1,0,0,1,1,1};
        int[] colN = {-1,0,1,-1,1,-1,0,1};

        visited[row][column] = true;

        for(int i=0;i<8;i++){
            if(isValid(nodes, row+rowN[i],column+colN[i],visited,M, N)){
                dfs(nodes,visited,row+rowN[i],column+colN[i],M, N);
            }
        }

    }

    private static boolean isValid(int[][] nodes, int row, int column, boolean[][] visited, int M, int N) {
        if(row<0 || row >M){
            return false;
        }
        if(column<0 || column>N){
            return false;
        }

        if(visited[row][column]== true || nodes[row][column]!=1){
            return false;
        }
        return true;
    }

}
