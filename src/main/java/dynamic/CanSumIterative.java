package dynamic;

import java.util.Arrays;

public class CanSumIterative {

    public static void main(String[] args) {
        int[] numbers= new int[]{7,14};
        System.out.println(canSum(300,numbers));
    }

    public static boolean canSum(int target, int[] numbers){
        boolean[] numpos= new boolean[target+1];
        Arrays.fill(numpos,false);
        numpos[0]=true;
        for(int i=0;i<numpos.length;i++){
            if(numpos[i]){
                for(int number:numbers){
                    if(i+number<target+1){
                        numpos[i+number]=true;
                        if(i+number==target){
                            return true;
                        }
                    }
                }
            }
        }
        return numpos[target];
    }
}
