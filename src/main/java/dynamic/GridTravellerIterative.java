package dynamic;

import java.util.Arrays;

public class GridTravellerIterative {

    public static void main(String[] args) {
        System.out.println(countWays(18,18));
    }

    private static long countWays(int m, int n) {
        long[][] grid= new long[m+1][n+1];
        for(int i=0;i<m+1;i++){
            Arrays.fill(grid[i],0);
        }
        grid[1][1]=1;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(j+1<=n){
                    grid[i][j+1]= grid[i][j]+grid[i][j+1];
                }
                if(i+1<=m){
                    grid[i+1][j]= grid[i][j]+grid[i+1][j];
                }
            }
        }
        return grid[m][n];
    }


}
