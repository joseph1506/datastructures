package dynamic;

import java.util.Arrays;

public class EggDropProblem {
    public static void main(String[] args) {
        System.out.println(solveUsingDp(8,4));
    }

    private static int solveUsingDp(int n, int e) {
        int[][] tries= new int[n+1][e+1];


        for(int i=1;i<e+1;i++){
            tries[1][i]=1;
        }

        for(int i=1;i<n+1;i++){
            tries[i][1]=i;
        }

        for(int i=2;i<n+1;i++){
            /// I floor
            for(int j=2;j<e+1;j++){
                // J Eggs
                tries[i][j]=Integer.MAX_VALUE;
                // F[I][J]=  min{k=1 to I-1}(  max(F[k-I][J],F[I-1][J-1])+1)
                for(int k=1;k<i;k++){
                    int eggSurvivedResult= tries[i-k][j];
                    int eggBrokenResult= tries[k-1][j-1];
                    int temp= Math.max(eggSurvivedResult,eggBrokenResult)+1;
                    if(temp<tries[i][j]){
                        tries[i][j]=temp;
                    }
                }
            }
        }


        /*for(int i=1;i<n+1;i++){
            for(int j=1;j<e+1;j++){
                System.out.print(tries[i][j]+" ");

            }
            System.out.println("");
        }*/
        return tries[n][e];
    }
}
