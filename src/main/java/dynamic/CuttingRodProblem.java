package dynamic;

import java.util.Arrays;

public class CuttingRodProblem {

    public static void main(String[] args) {
        int[] lengths = {1,2,3,4};
        int[] costs = {2,5,7,8};
        int rodLength = 5;
        int[][] memoize= new int[lengths.length][rodLength+1];
        for(int i=0;i< lengths.length;i++){
            Arrays.fill(memoize[i],-1);
        }
        System.out.println(recursion(lengths,costs,0,rodLength,memoize));
        System.out.println(dpSolution(lengths,costs,rodLength));
    }

    private static int recursion(int[] lengths, int[] costs, int position, int rodLength, int[][] memoize) {
        if(position<lengths.length && memoize[position][rodLength]!=-1) return memoize[position][rodLength];

        if(rodLength<=0 || position==lengths.length) return 0;

        if(lengths[position]>rodLength){
            int cost= recursion(lengths,costs,position+1,rodLength, memoize);
            memoize[position][rodLength]=cost;
            return cost;
        }else{
            int cost1= costs[position]+ recursion(lengths,costs,position+1,rodLength-lengths[position], memoize);
            int cost2= recursion(lengths,costs,position+1,rodLength, memoize);
            memoize[position][rodLength]=Math.max(cost1,cost2);
            return Math.max(cost1,cost2);
        }
    }

    private static int dpSolution(int[] lengths, int[] costs, int rodLength){
        int[][] solution = new int[lengths.length][rodLength+1];
        for(int i=0;i<solution.length;i++){
            solution[i][0]=0;
        }

        for(int i=0;i<solution.length;i++){
            int costI= costs[i];
            int lengthI= lengths[i];

            for(int j=1;j<=rodLength;j++){

                if(lengthI>j){
                    // get value before the position
                    if(i==0){
                        solution[i][j]=0;
                    }else{
                        solution[i][j]=solution[i-1][j];
                    }
                }else {
                    if(i==0){
                        solution[i][j]=costI+solution[i][j-lengthI];
                    }else{
                        //get value after considering
                        int valAfterIncluding = costI + solution[i - 1][j - lengthI];

                        //get value without considering
                        int valAfterExcluding = solution[i - 1][j];

                        //take max
                        solution[i][j] = Math.max(valAfterIncluding, valAfterExcluding);
                    }
                }
            }
        }
        return solution[lengths.length-1][rodLength];
    }
}
