package algorithms;

import java.util.Arrays;

public class KnapsackAlgo {

    public static void main(String[] args) {
        int[] weights = {1,2,4,2,5};
        int[] values = {5,3,5,3,2};
        int weight = 10;
        int[][] memorized = new int[weights.length][weight+1];
        for(int i=0;i<weights.length;i++){
            Arrays.fill(memorized[i],-1);
        }
        System.out.println(knapSack(weights,values,4,weight,memorized));
    }

    private static int knapSack(int[] weights, int[] values, int pos, int weight,int[][] memorized) {
        if(memorized[pos][weight]!=-1) return memorized[pos][weight];
        int result =0;
        if(pos ==0 || weight==0) return 0;
        else if(weights[pos]>weight){
            result = knapSack(weights,values,pos-1,weight,memorized);
        } else{
            int temp1 = knapSack(weights,values,pos-1,weight,memorized);
            int temp2 = values[pos] + knapSack(weights,values,pos-1,weight- weights[pos],memorized);
            result = Math.max(temp1,temp2);
        }
        memorized[pos][weight] = result;
        return result;
    }
}
