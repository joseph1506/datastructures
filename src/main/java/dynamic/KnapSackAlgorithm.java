package dynamic;

import java.util.Arrays;

public class KnapSackAlgorithm {

    public static void main(String[] args) {
        /*int[] weights = {1,2,4,2,5};
        int[] values = {5,3,5,3,2};
        int capacityRem = 10;*/
        int[] weights = {10,20,30};
        int[] values = {60,100,120};
        int capacityRem = 50;
        int[][] memoize= new int[weights.length][capacityRem+1];
        for(int i=0;i< weights.length;i++){
            Arrays.fill(memoize[i],-1);
        }
        System.out.println(knapSackRecusrion(weights,values,0,capacityRem,memoize));

        //int[][] memorized = new int[weights.length][weight+1];
        //
        System.out.println(knapSackDPIteration(weights,values,capacityRem));
    }

    private static int knapSackRecusrion(int[] weights, int[] values, int position, int capacityRem, int[][] memoize) {
        if(position<weights.length && memoize[position][capacityRem]!=-1) return memoize[position][capacityRem];

        if(position==weights.length || capacityRem==0) return 0;

        if(weights[position]>capacityRem){
            int value= knapSackRecusrion(weights,values,position+1,capacityRem, memoize);
            memoize[position][capacityRem]=value;
            return value;
        }
        else{
            int valueWithPosWeight=  values[position]+knapSackRecusrion(weights,values,position+1,capacityRem-weights[position], memoize);
            int valueWithoutPosWeight=  knapSackRecusrion(weights,values,position+1,capacityRem, memoize);
            int maxValue=Math.max(valueWithoutPosWeight,valueWithPosWeight);
            memoize[position][capacityRem]=maxValue;
            return maxValue;
        }
    }

    private static int knapSackDPIteration(int[] weights, int[] values, int capacity) {
        int[][] weightMatrix= new int[weights.length][capacity+1];
        for(int i=0;i<weights.length;i++){
            weightMatrix[i][0]=0;
        }
        // start from 1st weight and value
        for(int i=0;i<weights.length;i++){
            int weight=weights[i];
            int value= values[i];
            for(int j=1;j<capacity+1;j++){
                if(weight>j){
                    if(i==0){
                        weightMatrix[i][j]=0;
                    }else{
                        weightMatrix[i][j]= weightMatrix[i-1][j];
                    }
                } else {
                    if(i==0){
                        weightMatrix[i][j]=value;
                    } else {
                        int ifTakenCurrWeight= value+ weightMatrix[i-1][j-weight];
                        int ifNotTakenCurrWeight= weightMatrix[i-1][j];
                        weightMatrix[i][j]=Math.max(ifTakenCurrWeight,ifNotTakenCurrWeight);
                    }
                }
            }
        }
        return weightMatrix[weights.length-1][capacity];
    }
}
