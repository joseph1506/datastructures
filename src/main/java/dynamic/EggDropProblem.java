package dynamic;

import java.util.HashMap;
import java.util.Map;

public class EggDropProblem {
    public static void main(String[] args) {
        Map<String,Integer> floorEggTries= new HashMap<>();
        System.out.println(solveUsingDp(8,4));
        System.out.println(eggDropRecursion(8,4,floorEggTries));

        /*System.out.println(solveUsingDp(10,2));
        System.out.println(eggDropRecursion(10,2));*/
    }

    private static int eggDropRecursion(int floors, int eggs, Map<String, Integer> floorEggTries) {
        if(floorEggTries.containsKey(floors+"-"+eggs)) return floorEggTries.get(floors+"-"+eggs);

        // if floors =1 or 0 and egg can be any number
        if(floors==0|| floors==1){
            return floors;
        }
        // if only one egg
        if(eggs==1){
            return floors;
        }

        int minTries=Integer.MAX_VALUE;
        for(int x=1;x<=floors;x++){
            int tries= Math.max(eggDropRecursion(x-1,eggs-1, floorEggTries),eggDropRecursion(floors-x,eggs, floorEggTries));
            if(tries<minTries){
                minTries=tries;
            }
        }
        floorEggTries.put(floors+"-"+eggs,minTries+1);
        return minTries+1;
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


        for(int i=1;i<n+1;i++){
            for(int j=1;j<e+1;j++){
                System.out.print(tries[i][j]+" ");

            }
            System.out.println("");
        }
        return tries[n][e];
    }


}
